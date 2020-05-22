package Server.src;

import ClientServer.model.Envelope;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Level;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

public class WebServer {

    public static class EmbeddedAsyncServlet extends HttpServlet {
        Envelope envelope = new Envelope();
        public static ArrayList<Envelope> envelopeList = new ArrayList<>();
        public static int i;
        public static int index;
        @Override
        protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
            final AsyncContext ctxt = req.startAsync();
            ctxt.start(new Runnable() {
                @Override
                public void run() {
                    System.err.println("Do get");
                    String get = req.getParameter("UUID");
                    try {
                            if (checkListForMessage(get)==true) {
                                try {
                                    System.out.print("eeeeeeeeee");
                                    byte[] b = serialize(envelopeList.get(index));
                                    String encoded = new String(Base64.encodeBase64(b));
                                    resp.getWriter().append(encoded);
                                    envelopeList.remove(index);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ctxt.complete();
                }
            });
        }

        @Override
        protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
            final AsyncContext ctxt = req.startAsync();
            ctxt.start(new Runnable() {
                @Override
                public void run() {
                    System.err.println("Do post");
                    try {
                            String s = req.getParameter("key1");
                            byte[] decoded = Base64.decodeBase64(s);
                            envelope = (Envelope) deserialize(decoded);
                            if (checkListForPair(envelope.userIdentifier, envelope.clientIdentifier) == false) {
                                envelopeList.add(envelope);
                                resp.getWriter().append("Approved");
                            }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    ctxt.complete();
                }
            });
        }

        public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
            ByteArrayInputStream b = new ByteArrayInputStream(bytes);
            ObjectInputStream o = new ObjectInputStream(b);
            return o.readObject();
        }

        public static byte[] serialize(Object obj) throws IOException {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            ObjectOutputStream o = new ObjectOutputStream(b);
            o.writeObject(obj);
            return b.toByteArray();
        }

        public static Boolean checkListForPair(String user, String client) {
            for (Envelope envelope : envelopeList) {
                if (envelope.userIdentifier.equals(user) & envelope.clientIdentifier.equals(client)) {
                    return true;
                }
            }
            return false;
        }
        public static Boolean checkListForMessage(String client) {
            i=-1;
            for (Envelope envelope : envelopeList) {
                i++;
                if (envelope.clientIdentifier.equals(client)) {
                    index=i;
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        org.apache.log4j.LogManager.getLogger("org.eclipse.jetty").setLevel(Level.WARN);
        Server server = new Server(1883);
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.setAllowNullPathInfo(true);
        ServletHolder asyncHolder = context.addServlet(EmbeddedAsyncServlet.class, "/");
        asyncHolder.setAsyncSupported(true);
        server.setHandler(context);
        server.start();
        server.join();
    }
}
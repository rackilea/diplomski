import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class JettyHttpServer extends AbstractHandler
{
    private static Server server = null;

    public Server getServer()
    {
        return server;
    }

    public static void startServer(int webServerPort) throws Exception
    {
        System.out.println("Initializing server");
        server = new Server(webServerPort);
        server.setHandler(new JettyHttpServer());
        server.start();
    }

    public static void stopServer() throws Exception
    {
        try
        {
            server.stop();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            throw new Exception("Could not stop server", ex);
        }
    }

    public void handle(String pathInContext, Request request, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException
    {
        System.out.println("inside Jetty Server...");
boolean requestWrongFlag = true

        if (httpRequest.getMethod().equals("POST"))
        {
            BufferedReader reader = httpRequest.getReader();
            String line;
            do {
            line = reader.readLine();
//do the validation here on the request received and in case it is not correct raise the requestWrongFlag
            System.out.println(line);
            }while (line!=null);


            httpResponse.setContentType("text/html;charset=utf-8");
           if(!requestWrongFlag)
               httpResponse.setStatus(HttpServletResponse.SC_ACCEPTED);
           else
                       httpResponse.setStatus(httpServletResponse.sc_BAD_REQUEST)
            httpResponse.getWriter().println("OK");
            request.setHandled(true);
        }
    }
}
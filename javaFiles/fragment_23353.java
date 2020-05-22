package jetty.errors;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpTester;
import org.eclipse.jetty.server.LocalConnector;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.util.IO;

public class HandlerWithError
{
    public static class MyRequestHandler extends AbstractHandler
    {
        @Override
        public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException
        {
            System.out.println("MyRequestHandler.handle() - DispatcherType: " + request.getDispatcherType());
            // only work with REQUEST Dispatches
            if (!DispatcherType.REQUEST.equals(request.getDispatcherType()))
            {
                // skip this handler
                return;
            }

            // Set handled (by this handler), don't let other handlers operate on this request
            baseRequest.setHandled(true);
            // read request body into string
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            // apache commons copy
            IO.copy(request.getInputStream(), bos);
            String body = new String(bos.toByteArray());
            System.out.println("request body: " + body);
            throw new NullPointerException();
        }
    }

    public static class MyErrorHandler extends AbstractHandler
    {
        @Override
        public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException
        {
            System.out.println("MyErrorHandler.handle() - DispatcherType: " + request.getDispatcherType());
            if(!DispatcherType.ERROR.equals(request.getDispatcherType()))
            {
                // skip this handler
                return;
            }

            baseRequest.setHandled(true);
            response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            response.setContentType("text/plain");
            response.getWriter().println("Go away, you silly NPE fool");
        }
    }

    public static void main(String args[])
            throws Exception
    {
        Server server = new Server();
        HandlerList handlers = new HandlerList();
        // Add your ERROR Dispatch handler first to handle dispatches for errors
        handlers.addHandler(new MyErrorHandler());
        // Add your handlers here (can be more then one)
        handlers.addHandler(new MyRequestHandler());
        // Always add DefaultHandler last, to ensure that something in your handler
        // list is calling baseRequest.setHandled(true)
        handlers.addHandler(new DefaultHandler());
        server.setHandler(handlers);
        LocalConnector localConnector = new LocalConnector(server);
        server.addConnector(localConnector);
        server.start();

        try
        {
            String simpleRequest = "GET / http/1.1\r\n" +
                    "Host: localhost:0\r\n" +
                    "Connection: close\r\n" +
                    "Content-Type: text/plain\r\n" +
                    "Content-Length: 2\r\n\r\nhi";
            HttpTester.Response response = HttpTester.parseResponse(
                    localConnector.getResponse(simpleRequest));
            System.out.println("Response: " + response);
            System.out.println(response.getContent());
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
        finally
        {
            server.stop();
        }
    }
}
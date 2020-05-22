package jetty.errors;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.LocalConnector;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.util.IO;

public class HandlerWithError extends AbstractHandler
{
    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException
    {
        if (DispatcherType.REQUEST.equals(httpServletRequest.getDispatcherType()))
        {
            // read request body into string
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            // apache commons copy
            IO.copy(httpServletRequest.getInputStream(), bos);
            String body = new String(bos.toByteArray());
            System.out.println("request body: " + body);
            throw new NullPointerException();
        }
        else
        {
            System.out.println("Now in DispatchType: " + httpServletRequest.getDispatcherType());
        }
    }

    public static void main(String args[])
            throws Exception
    {
        Server server = new Server();
        server.setHandler(new HandlerWithError());
        LocalConnector localConnector = new LocalConnector(server);
        server.addConnector(localConnector);
        server.start();
        String simpleRequest = "GET / http/1.1\r\n" +
                "Host: localhost:0\r\n" +
                "Connection: close\r\n" +
                "Content-Type: text/plain\r\n" +
                "Content-Length: 2\r\n\r\nhi";
        String response = localConnector.getResponse(simpleRequest);
        server.join();
    }
}
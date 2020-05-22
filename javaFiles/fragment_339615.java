package jetty.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.HandlerWrapper;

public class ModifyRequestHeadersHandler extends AbstractHandler
{
    @Override
    public void handle(String target, Request baseRequest, 
        HttpServletRequest request, HttpServletResponse response) 
        throws IOException, ServletException
    {
        // As fully fleshed out field
        final HttpField X_MY_TEST = new HttpField("X-My-Test", "MyName");
        baseRequest.getHttpFields().put(X_MY_TEST);

        // As predefined header and custom value
        baseRequest.getHttpFields().put(HttpHeader.X_POWERED_BY,
            "ModifiedRequestHeadersHandler");

        // As string header and string value
        baseRequest.getHttpFields().put("X-Foo-Test", "MyFooName");
    }
}
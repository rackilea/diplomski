package com.test.server;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import java.io.IOException;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.core.ClassNamesResourceConfig;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;
import org.glassfish.grizzly.servlet.ServletRegistration;
import org.glassfish.grizzly.servlet.WebappContext;

public class Main {
    private static final String JERSEY_SERVLET_CONTEXT_PATH = "";

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost").port(8080).path("/").build();
    }

    public static final URI BASE_URI = getBaseURI();

    public static void main(String[] args) throws IOException {
        // Create HttpServer and register dummy "not found" HttpHandler
        HttpServer httpServer = GrizzlyServerFactory.createHttpServer(BASE_URI, new HttpHandler() {

            @Override
            public void service(Request rqst, Response rspns) throws Exception {
                rspns.setStatus(404, "Not found");
                rspns.getWriter().write("404: not found");
            }
        });

        // Initialize and register Jersey Servlet
        WebappContext context = new WebappContext("WebappContext", JERSEY_SERVLET_CONTEXT_PATH);
        ServletRegistration registration = context.addServlet("ServletContainer", ServletContainer.class);
        registration.setInitParameter(ServletContainer.RESOURCE_CONFIG_CLASS, 
                ClassNamesResourceConfig.class.getName());
        registration.setInitParameter(ClassNamesResourceConfig.PROPERTY_CLASSNAMES, LolCat.class.getName());
        registration.addMapping("/*");
        context.deploy(httpServer);

        System.in.read();
        httpServer.stop();
    }
}
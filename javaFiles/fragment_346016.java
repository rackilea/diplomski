package jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.PathResource;

import java.io.File;
import java.nio.file.Path;

public class ManyDefaultServlet
{
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.addConnector(connector);

        // The filesystem paths we will map
        Path homePath = new File(System.getProperty("user.home")).toPath().toRealPath();
        Path pwdPath = new File(System.getProperty("user.dir")).toPath().toRealPath();

        // Setup the basic application "context" for this application at "/"
        // This is also known as the handler tree (in jetty speak)
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.setBaseResource(new PathResource(pwdPath));
        server.setHandler(context);

        // Fist, add special pathspec of "/home/" content mapped to the homePath
        ServletHolder holderHome = new ServletHolder("static-home", DefaultServlet.class);
        holderHome.setInitParameter("resourceBase",homePath.toUri().toASCIIString());
        holderHome.setInitParameter("dirAllowed","true");
        // Use request pathInfo, don't calculate from contextPath
        holderHome.setInitParameter("pathInfoOnly","true");
        context.addServlet(holderHome,"/foo/*"); // must end in "/*" for pathInfo to work

        // Lastly, the default servlet for root content
        // It is important that this is last.
        String defName = "default"; // the important "default" name
        ServletHolder holderDef = new ServletHolder(defName, DefaultServlet.class);
        holderDef.setInitParameter("dirAllowed","true");
        context.addServlet(holderDef,"/"); // the servlet spec "default url-pattern"

        server.start();
        server.join();
    }
}
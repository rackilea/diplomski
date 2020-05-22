package jetty.resource;

import java.net.URI;
import java.net.URL;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;

public class ResourceHandlerExample
{
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);

        // Figure out what path to serve content from
        ClassLoader cl = ResourceHandlerExample.class.getClassLoader();
        // We look for a file, as ClassLoader.getResource() is not
        // designed to look for directories (we resolve the directory later)
        URL f = cl.getResource("webroot/index.html");
        if (f == null)
        {
            throw new RuntimeException("Unable to find resource directory");
        }

        // Resolve file to directory
        URI webRootUri = f.toURI().resolve("./").normalize();
        System.err.println("WebRoot is " + webRootUri);

        ResourceHandler handler = new ResourceHandler();
        handler.setBaseResource(Resource.newResource(webRootUri));

        server.setHandler(handler);

        server.start();
        server.join();
    }
}
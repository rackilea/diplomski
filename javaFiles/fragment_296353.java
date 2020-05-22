package jetty;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.IO;

public class MimeTypeJsonExample
{
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(9090);
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(JsonServlet.class, "/demo");
        context.addServlet(DefaultServlet.class, "/"); // handle static content and errors for this context
        HandlerList handlers = new HandlerList();
        handlers.addHandler(context);
        handlers.addHandler(new DefaultHandler()); // handle non-context errors
        server.setHandler(context);
        server.start();

        try
        {
            demonstrateJsonBehavior(server.getURI().resolve("/"));
        }
        finally
        {
            server.stop();
        }
    }

    private static void demonstrateJsonBehavior(URI serverBaseUri) throws IOException
    {
        HttpURLConnection http = (HttpURLConnection) serverBaseUri.resolve("/demo").toURL().openConnection();
        dumpRequestResponse(http);
        System.out.println();
        try (InputStream in = http.getInputStream())
        {
            System.out.println(IO.toString(in, UTF_8));
        }
    }

    private static void dumpRequestResponse(HttpURLConnection http) throws IOException
    {
        System.out.println();
        System.out.println("----");
        System.out.printf("%s %s HTTP/1.1%n", http.getRequestMethod(), http.getURL());
        System.out.println("----");
        System.out.printf("%s%n", http.getHeaderField(null));
        http.getHeaderFields().entrySet().stream()
                .filter(entry -> entry.getKey() != null)
                .forEach((entry) -> System.out.printf("%s: %s%n", entry.getKey(), http.getHeaderField(entry.getKey())));
    }

    public static class JsonServlet extends HttpServlet
    {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            resp.setHeader("X-Charset", resp.getCharacterEncoding());
            writer.println("{\"mode\":[\"a=b\"],\"animals\":[[\"kiwi bird\",\"kea\",\"skink\"]]}");
        }
    }
}
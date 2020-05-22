package foo.bar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesServiceFactory;

@SuppressWarnings("serial")
public class MyFirstWebAppServlet extends HttpServlet {
    @Override
    public void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        URL url;
        if ("exists".equals(req.getParameter("image"))) {
            url = new URL("https://www.google.com/logos/classicplus.png");
        } else if ("notImage".equals(req.getParameter("image"))) {
            url = new URL("http://www.google.com");
        } else {
            url = new URL("http://foo.bar/image.png");
        }

        resp.setContentType("text/plain");
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            final InputStream inputStream = url.openStream();
            int read;
            while ((read = inputStream.read()) != -1) {
                baos.write(read);
            }

            final Image image = ImagesServiceFactory.makeImage(baos.toByteArray());

            resp.getWriter().println("image width: " + image.getWidth());
            resp.getWriter().println("image height: " + image.getHeight());
        } catch (final IOException e) {
            resp.getWriter().println("image doesn't exists!");
        } catch (final IllegalArgumentException e) {
            resp.getWriter().println("invalid image!");
        }

    }
}
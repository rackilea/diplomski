import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        URL[] urls = { new URL("http://yourserver/small.png") };
        for (URL url : urls) {
            ImageInputStream iis = ImageIO.createImageInputStream(url
                    .openStream());
            Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);

            System.out.println("url= " + url.getPath());
            while (readers.hasNext()) {
                ImageReader read = readers.next();
                System.out.println("format name = " + read.getFormatName());
            }
            System.out.println();
        }
    }
}
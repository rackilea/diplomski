import java.awt.*;
import java.awt.image.BufferedImage;
import javax.xml.bind.DatatypeConverter;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.*;

public class DataUriConverter {

    public static void main(String[] args) throws Exception {
        int sz = 200;
        BufferedImage image = new BufferedImage(
                sz, sz, BufferedImage.TYPE_INT_ARGB);

        // paint the image..
        Graphics2D g = image.createGraphics();
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.BLUE);
        for (int ii = 0; ii < sz; ii += 5) {
            g.drawOval(ii, ii, sz - ii, sz - ii);
        }
        g.dispose();

        // convert the image
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        System.out.println("baos.toByteArray() " + baos.toByteArray());
        System.out.println("baos.toByteArray().length " + baos.toByteArray().length);
        String data = DatatypeConverter.printBase64Binary(baos.toByteArray());
        String imageString = "data:image/png;base64," + data;
        String html =
                "<html><body><img src='" + imageString + "'></body></html>";

        // write the HTML
        File f = new File("image.html");
        FileWriter fw = new FileWriter(f);
        fw.write(html);
        fw.flush();
        fw.close();

        // display the HTML
        Desktop.getDesktop().open(f);
    }
}
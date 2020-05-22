import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;


public class Example {

    public static void main(String[] args) throws IOException {
        InputStream is = Example.class.getResourceAsStream("Lenna.png");
        BufferedImage bi = ImageIO.read(is);

        rescale(bi);

        for(int i=1;i<10;i++){
            compress(i,bi);
        }

    }

    private static void rescale(BufferedImage bi) throws IOException {
        int originalWidth = bi.getWidth();
        int originalHeight = bi.getHeight();
        int type = bi.getType() == 0? BufferedImage.TYPE_INT_ARGB : bi.getType();

        //rescale 50%
        BufferedImage resizedImage = new BufferedImage(originalWidth/2, originalHeight/2, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(bi, 0, 0, originalWidth/2, originalHeight/2, null);
        g.dispose();
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        ImageIO.write(resizedImage, "jpg", new File("Lenna50.jpg"));
    }

    private static void compress(int compression, BufferedImage bi)
            throws FileNotFoundException, IOException {
        Iterator<ImageWriter> i = ImageIO.getImageWritersByFormatName("jpeg");
        ImageWriter jpegWriter = i.next();

        // Set the compression quality
        ImageWriteParam param = jpegWriter.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(0.1f * compression);

        // Write the image to a file
        FileImageOutputStream out = new FileImageOutputStream(new File("Lenna"+compression+".jpg"));
        jpegWriter.setOutput(out);
        jpegWriter.write(null, new IIOImage(bi, null, null), param);
        jpegWriter.dispose();
        out.close();
    }

}
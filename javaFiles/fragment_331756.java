import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.IndexColorModel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class IndexedBufferedImage
{
    public static void main(String[] args) throws IOException
    {
        BufferedImage image = ImageIO.read(new File("exampleTiff256.tif"));
        System.out.println(image);
        System.out.println(image.getColorModel());

        ColorModel colorModel = image.getColorModel();
        IndexColorModel indexColorModel = null;
        if (colorModel instanceof IndexColorModel)
        {
            indexColorModel = (IndexColorModel)colorModel;
        }
        else
        {
            System.out.println("No IndexColorModel");
            return;
        }

        DataBuffer dataBuffer = image.getRaster().getDataBuffer();
        DataBufferByte dataBufferByte = null;
        if (dataBuffer instanceof DataBufferByte)
        {
            dataBufferByte = (DataBufferByte)dataBuffer;
        }
        else
        {
            System.out.println("No DataBufferByte");
            return;
        }

        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage test = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        byte data[] = dataBufferByte.getData();
        for (int y=0; y<h; y++)
        {
            for (int x=0; x<w; x++)
            {
                int arrayIndex = x + y * w;
                int colorIndex = data[arrayIndex];
                int color = indexColorModel.getRGB(colorIndex);
                System.out.println("At "+x+" "+y+" index is "+colorIndex+
                    " with color "+Integer.toHexString(color));
                test.setRGB(x, y, color);
            }
        }
        ImageIO.write(test, "PNG", new File("exampleTiff256.png"));
    }
}
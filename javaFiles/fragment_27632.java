import java.awt.image.*;

BufferedImage im = new BufferedImage(//....);

if(im.getColorModel().getColorSpace() == ColorSpace.TYPE_RGB)
    //do stuff...
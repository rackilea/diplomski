package validators;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import play.Logger;
import play.data.validation.Check;
import play.db.jpa.Blob;
import play.i18n.Messages;

public class ImageValidator extends Check {

  public final static int MAX_SIZE = 4048;
  public final static int MAX_HEIGHT = 1920;

  @Override
  public boolean isSatisfied(Object parent, Object image) {

    if (!(image instanceof Blob)) {
        return false;
    }

    if (!((Blob) image).type().equals("image/jpeg") && !((Blob) image).type().equals("image/png")) {
        return false;
    }

    // size check
    if (((Blob) image).getFile().getLength() > MAX_SIZE) {
        return false;
    }


    try {
        BufferedImage source = ImageIO.read(((Blob) image).getFile());
        int width = source.getWidth();
        int height = source.getHeight();

        if (width > MAX_WIDTH || height > MAX_HEIGHT) {
            return false;
        }
    } catch (IOException exption) {
        return false;
    }


    return true;
    }
}
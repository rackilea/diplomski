package sub.optimal;

import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriter;
import javax.imageio.spi.ImageWriterSpi;
import java.io.IOException;
import java.util.Locale;

public class ExampleImageWriterSpi extends ImageWriterSpi {

    private static final String[] formatNames = { "xyz", "XYZ"};

    public String getDescription(Locale locale) {
        return "Example XYZ image writer";
    }

    @Override
    public String[] getFormatNames() {
        return formatNames;
    }

    // following is without implementation in this example
    public boolean canEncodeImage(ImageTypeSpecifier type) {
        return false;
    }

    public ImageWriter createWriterInstance(Object extension) throws IOException {
        return null;
    }
}
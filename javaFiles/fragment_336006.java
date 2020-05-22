import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.Base64;
import java.util.UUID;
import javax.imageio.ImageIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Override
public String getImage(String productNumber) throws EcomWebException {

try {
    BufferedImage image = ImageIO.read(url);
    File file = new File(guid.toString() + ".jpg");
    ImageIO.write(image, "jpg", file);
    String base64ImageString = Base64.getEncoder().encodeToString(Files.readAllBytes(file.toPath()));
    file.delete();
    return base64ImageString;
} catch (Exception e) {
    throw new EcomWebException(IMAGE_NOT_FOUND_MESSAGE + productNumber, e);
}
}
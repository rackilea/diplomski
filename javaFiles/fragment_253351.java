// Needed Imports
import java.io.ByteArrayInputStream;
import sun.misc.BASE64Decoder;


def sourceData = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAPAAAADwCAYAAAA+VemSAAAgAEl...==';

// tokenize the data
def parts = sourceData.tokenize(",");
def imageString = parts[1];

// create a buffered image
BufferedImage image = null;
byte[] imageByte;

BASE64Decoder decoder = new BASE64Decoder();
imageByte = decoder.decodeBuffer(imageString);
ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
image = ImageIO.read(bis);
bis.close();

// write the image to a file
File outputfile = new File("image.png");
ImageIO.write(image, "png", outputfile);
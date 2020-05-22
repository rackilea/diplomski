import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;

//----

float quality = 0.85f;
File outfile = new File( "MyImage.jpg" );
BufferedImage image = ...;

ImageWriter imgWriter = ImageIO.getImageWritersByFormatName( "jpg" ).next();
ImageOutputStream ioStream = ImageIO.createImageOutputStream( outfile );
imgWriter.setOutput( ioStream );

JPEGImageWriteParam jpegParams = new JPEGImageWriteParam( Locale.getDefault() );
jpegParams.setCompressionMode( ImageWriteParam.MODE_EXPLICIT );
jpegParams.setCompressionQuality( quality );

imgWriter.write( null, new IIOImage( image, null, null ), jpegParams );

ioStream.flush();
ioStream.close();
imgWriter.dispose();
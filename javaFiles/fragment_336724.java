import javax.media.jai.PlanarImage;
  import com.sun.media.jai.codec.ByteArraySeekableStream;
  import com.sun.media.jai.codec.ImageCodec;
  import com.sun.media.jai.codec.ImageDecoder;
  import com.sun.media.jai.codec.SeekableStream;
  import java.awt.Image;
  import java.awt.image.RenderedImage;
...
  static Image load(byte[] data) throws Exception{
    Image image = null;
    SeekableStream stream = new ByteArraySeekableStream(data);
    String[] names = ImageCodec.getDecoderNames(stream);
    ImageDecoder dec = 
      ImageCodec.createImageDecoder(names[0], stream, null);
    RenderedImage im = dec.decodeAsRenderedImage();
    image = PlanarImage.wrapRenderedImage(im).getAsBufferedImage();
    return image;
  }
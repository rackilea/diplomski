import java.io.ByteArrayOutputStream;
...
// example image
BufferedImage image = new BufferedImage(4, 3, BufferedImage.TYPE_INT_ARGB);

// to array
ByteArrayOutputStream bos = new ByteArrayOutputStream();
ImageIO.write(image, "jpg", bos);
byte [] output = bos.toByteArray();
System.out.println(Arrays.toString(output));
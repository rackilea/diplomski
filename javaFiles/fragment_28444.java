public void toJ2000(String inputFile, String outputFile) throws IOException {
J2KImageWriteParam iwp = new J2KImageWriteParam();
FileInputStream fis = new FileInputStream(new File(inputFile));
BufferedImage image = ImageIO.read(fis);
fis.close();

if (image == null) 
{
    System.out.println("If no registered ImageReader claims to be able to read the resulting stream");
}

Iterator writers = ImageIO.getImageWritersByFormatName("JPEG2000");
String name = null;
ImageWriter writer = null;
while (name != "com.sun.media.imageioimpl.plugins.jpeg2000.J2KImageWriter") {
    writer = (ImageWriter) writers.next();
    name = writer.getClass().getName();
    System.out.println(name);
}
File f = new File(outputFile);
long s = System.currentTimeMillis();
ImageOutputStream ios = ImageIO.createImageOutputStream(f);
writer.setOutput(ios);
J2KImageWriteParam param = (J2KImageWriteParam) writer.getDefaultWriteParam();
IIOImage ioimage = new IIOImage(image, null, null);

writer.write(null, ioimage, param);
System.out.println(System.currentTimeMillis() - s);
writer.dispose();
ios.flush();
ios.close();

image.flush();
}

  public static void main(String[] args) {
    TR t=new TR();
    try {
       t.toJ2000("yel.png", "yel.j2k");
    }
    catch (Exception ex) { ex.printStackTrace(); }
  }
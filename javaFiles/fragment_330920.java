//Create file for the source
File input = new File("c:/temp/image.png");

//Read the file to a BufferedImage
BufferedImage image = ImageIO.read(input);

//Create a file for the output
File output = new File("c:/temp/image.bmp");

//Write the image to the destination as a BMP
ImageIO.write(image, "bmp", output);
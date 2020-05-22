//# load your old one as usual
image = ImageIO.read(f);

//# Create a new bufferdImage with type (will draw old into this) //also consider TYPE_INT_RGB
BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

//# Then draw original into new type...
Graphics2D g = newImage.createGraphics();
g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
g.dispose(); //needed or not???

//# Doing the For-loop
int imgW = image.getWidth();
int imgH = image.getHeight();
int pixels[][] = new int[imgW][imgH]; //create a 2D array

//# Fill Array : for each [x] pos we read down /column 
//# so that we fill [y] with those pixel values
for (int x = 0; x < imgW; x++) 
{
    //On each X pos we scan all Y pixels in that column 
    for (int y = 0; y < imgH; y++) 
    {
        int col = image.getRGB(x, y);
        pixels[x][y] = col;

        //printPixelARGB( col ); //if you need this format instead of printPixelMatrix
    }
} 

//# To Print output
public void printPixelMatrix()
{
    for (int i = 0; i < image.getHeight(); i++) 
    {
        for (int j = 0; j < image.getWidth(); j++) 
        {
            //System.out.print(" " + pixels[j][i] + " ");
            int c = pixels[j][i]; //get integer that was stored in the array
            String HexVal = Integer.toHexString( c ) //giveshex value like AARRGGBB
            System.out.print(" " + HexVal + " ");
        }

        System.out.print("\n");
    }        

}

//# Another helper function to print pixel values
//# print out example blue : argb: 255, 0, 0, 255
public void printPixelARGB(int pixel) 
{
    int alpha = (pixel >> 24) & 0xff;
    int red = (pixel >> 16) & 0xff;
    int green = (pixel >> 8) & 0xff;
    int blue = (pixel) & 0xff;
    System.out.println("ARGB : " + alpha + ", " + red + ", " + green + ", " + blue);
}
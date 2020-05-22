import java.awt.*;
public class CopyCatDemo
{
 public static void main(String[] args)
 {
    Picture sourcePicture = new Picture("earth.jpg");
    System.out.println("Width: " + sourcePicture.getWidth());
    System.out.println("Height: " + sourcePicture.getHeight());
    Picture targetPicture1 = new Picture(400,400);
    targetPicture1.setAllPixelsToAColor(Color.BLACK);

    int offsetX = 0;
    int offsetY = 0;

    Pixel sourcePixel, targetPixel = null;
    Color sourceColor, targetColor = null;

    for(int y = 0; y < sourcePicture.getHeight(); y++)
    {
        for(int x = 0; x < sourcePicture.getWidth(); x++)
        {
            sourcePixel = sourcePicture.getPixel(x,y);
            sourceColor = sourcePixel.getColor();
            targetPixel = targetPicture1.getPixel(offsetX + x, offsetY + y);
            targetPixel.setColor(sourceColor);         
        }
    }

    sourcePicture.show();
    targetPicture1.show();
    targetPicture1.write("NewFile.jpg");
 }//end of main method
}//end of class
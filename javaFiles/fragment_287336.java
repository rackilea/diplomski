import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;


public class PngReadWriteTest {

@Test
public void test(){
    try
    { 
    BufferedImage imgBuf = ImageIO.read(new File("test.png"));//also testing with GIFs, JPEGs
    int w = imgBuf.getWidth();
    int h = imgBuf.getHeight();
    int[] RGBarray = imgBuf.getRGB(0,0,w,h,null,0,w);

    //Arrays to store their respective component values
    int [][] redPixels = new int [h][w]; 
    int [][] greenPixels = new int [h][w]; 
    int [][] bluePixels = new int [h][w];

    System.out.println("IMAGE FIRST READ:");
    printPixelValues(imgBuf);

    //Separate the RGB int values into 3 array, red, green and blue ....
    int x=0;
    for(int row=0; row<h; row++)
    {
       for(int col=0; col<w; col++)
       {
          redPixels[row][col] = ((RGBarray[x]>>16)&0xff);
          greenPixels[row][col] = ((RGBarray[x]>>8)&0xff);
          bluePixels[row][col] = (RGBarray[x]&0xff);
          x++;
       }
    }

    //set pixels back using the setRBG() ...
    BufferedImage bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

    for(int row=0; row<h; row++)
    {
       for(int col=0; col<w; col++)
       {
          //use bit shifting to re-form the RGB int again
          int rgb = (redPixels[row][col] & 0xff) << 16 | (greenPixels[row][col] & 0xff) << 8 | (bluePixels[row][col] & 0xff);

          bufferedImage.setRGB(col, row, rgb);
       }
    }

    System.out.println("IMAGE BEFORE SAVE:");
    printPixelValues(bufferedImage);

    //Save image as png
    ImageIO.write(bufferedImage, "png", new File("new-test.png"));

    BufferedImage newImage = ImageIO.read(new File("new-test.png"));//also testing with GIFs, JPEGs

    System.out.println("IMAGE AFTER SECOND READ:");
    printPixelValues(newImage);

  }
  catch(IOException i){}; // This exception format is only temporary !
}

private void printPixelValues(BufferedImage image){
    int w = image.getWidth();
    int h = image.getHeight();
    int[] RGBarray = image.getRGB(0,0,w,h,null,0,w);

    for(int i=0; i<=10; i++)
    {
        //print out the first 10 RGB int values - testing purposes
        System.out.println(RGBarray[i]);
    }
}

}
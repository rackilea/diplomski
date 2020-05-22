import java.awt.image.BufferedImage;

public class Main
{

public static void main(String[] args)
    {
    BufferedImage right = new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_GRAY);
    int correct = 0, error = 0;
    for (int x=0 ; x < right.getWidth(); x++)
        for (int j = 0; j < right.getHeight(); j++)
            {
            int average = (int) (Math.random() * 255) ;
            right.getRaster().setSample(x, y, 0, average) ;
            if ( average != right.getRaster().getSample(x, y, 0) ) error++ ;
            else correct++;
            }
    System.out.println(correct + ", " + error);
    }
}
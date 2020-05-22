import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Equ{
    public static void main(String[] args) throws IOException {
        BufferedImage img = new BufferedImage( 20, 20, BufferedImage.TYPE_INT_ARGB );
        Graphics2D g = img.createGraphics();
        g.setColor( Color.white ); 
        g.fillRect( 0, 0, 20, 20 ); 
        g.setColor( Color.black ); 
        g.fillRect( 5, 5, 10, 10 ); 


        Color[] mapping = new Color[]{
            Color.black, Color.white, // replace black with white 
            Color.white, Color.green // and white with green
        };

        ImageIO.write( img, "png", new File( "original.png" ) ); 
        swapColors( img, mapping );     
        ImageIO.write( img, "png", new File( "swapped.png" ) ); 
    }


    public static void swapColors( BufferedImage img, Color ... mapping ){
        int[] pixels = img.getRGB( 0, 0, img.getWidth(), img.getHeight(), null, 0, img.getWidth() );
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for( int i = 0; i < mapping.length/2; i++ ){
            map.put( mapping[2*i].getRGB(), mapping[2*i+1].getRGB() ); 
        }


        for( int i = 0; i < pixels.length; i++ ){
            if( map.containsKey( pixels[i] ) )
                pixels[i] = map.get( pixels[i] ); 
        }

        img.setRGB( 0, 0, img.getWidth(), img.getHeight(), pixels, 0, img.getWidth() );  
    }
}
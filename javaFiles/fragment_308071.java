import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class EncodeImage  {

    public static void main(String[] args)  throws IOException{


        if(args.length!=0)
        {
        BufferedImage sourceImage = null;
        try {
            sourceImage = ImageIO.read(new File("inacup_donut.jpg"));
        } catch (IOException e) {
        }

        int type = sourceImage.getType();
        int w = sourceImage.getWidth();
        int h = sourceImage.getHeight();
        byte[] pixels = null;
        if (type == BufferedImage.TYPE_3BYTE_BGR)
        {
            System.out.println("type.3byte.bgr");
            pixels = (byte[]) sourceImage.getData().getDataElements(0, 0, w, h, null);
            //for(int i=0;i<pixels.length;i++)
                //pixels[i]=(byte) (pixels[i]|2);
            System.out.println(pixels[1]);

            int [] int_array=new int [pixels.length];
            for(int i=0;i< pixels.length;i++)
            {
            int_array [i]= pixels[i];
            }//end for loop



            int x []= encodeMessage(int_array,h,w,
                    "message") ;
            System.out.println("read " + x[0]+ " bytes,");
            byte [] new_bytearray = new byte [x.length] ;
            for(int i=0;i<x.length;i++)
            {
                new_bytearray[i]=(byte)x[i];
            }

            try {
                BufferedImage edgesImage = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
                edgesImage.getWritableTile(0, 0).setDataElements(0, 0, w, h, new_bytearray);
                ImageIO.write(edgesImage, "png", new File("snap.png"));
            } catch (IOException e) {
            }






        }
        } 
  }
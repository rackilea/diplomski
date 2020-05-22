import java.awt.*;
import java.awt.image.*;
import java.net.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
class imagesender
{
    imagesender()throws Exception
    {
        Socket soc=new Socket("127.0.0.1",5555);
        OutputStream os=soc.getOutputStream();
        while(true)
        {
            try
            {
                BufferedImage image=new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                ImageIO.write(image,"png",baos);
                baos.close();
                ObjectOutputStream oos=new ObjectOutputStream(os);
                oos.writeObject(baos.size()+"");
                os.write(baos.toByteArray());
                //System.out.println("Image Sent");
            }
            catch(Exception e)
            {
                System.exit(1);
            }
        }
    }
    public static void main(String aerg[])throws Exception
    {
        new imagesender();
    }
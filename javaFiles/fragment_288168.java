import java.awt.*;
import java.awt.image.*;
import java.net.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.*;
class imagereciever extends JPanel
{
    static BufferedImage image;
    static Socket soc;
    static InputStream is;
    imagereciever()throws Exception
    {
        ServerSocket ss=new ServerSocket(5555);
        soc=ss.accept();
        is=soc.getInputStream();
        JFrame frame=new JFrame();
        frame.setSize(500,500);
        frame.setContentPane(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        while(true)
        {
            try
            {
                ObjectInputStream ois=new ObjectInputStream(is);
                int size=Integer.parseInt(ois.readObject().toString());
                ByteArrayOutputStream baos=new ByteArrayOutputStream(size);
                int sizeread=0,bytesin=0;
                byte[] buffer=new byte[1024];
                while(sizeread<size)
                {
                    bytesin=is.read(buffer);
                    sizeread+=bytesin;
                    baos.write(buffer,0,bytesin);
                }
                baos.close();
                ByteArrayInputStream bais=new ByteArrayInputStream(baos.toByteArray());
                image=ImageIO.read(bais);
                this.repaint();
            }
            catch(Exception e)
            {
                System.exit(1);
            }
        }
    }
    public static void main(String aerg[])throws Exception
    {
        new imagereciever();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image,0,0,null);
    }
}
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;


public class BullsEye extends JPanel{

@Override
   public void paintComponent(Graphics g)
   {
   super.paintComponent(g);
   //for(int x =0; x>10;x++)
   //{
   int x=10;

       int y =(100-10*(x-1));
       //if((x%2)==0)
       //{
           g.setColor(Color.RED);//setting color
           g.drawRect(100, 10, 10, 15);//drawing
            g.drawOval(0, 0, 100, 100);//drawing
       //}
      // else
       //{
           g.setColor(Color.GREEN);//setting color
            g.fillOval(10, 10, 50, 50);//drawing
       //}
   //}


   }
    public static void main(String[] args) 
    {
        BullsEye b =  new BullsEye();//creating b varaible for drawings
     JFrame jf =  new JFrame();//frame varaible for the frame
     jf.setTitle("BullsEye");//setting title
     jf.setSize(500,400);//setting size

     jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//opertion close
     jf.add(b);//adding to the frame

     jf.setVisible(true);//setting it to visible
    }

}
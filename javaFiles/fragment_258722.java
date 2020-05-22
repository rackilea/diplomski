import javax.swing.Timer;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class DelayText
{

   public String example = "As you can see, this sentence is being printed out a character at a time.";
   public String transfer = "";
   public Timer t;
   public int i = 0;
   public JFrame f;
   public JLabel l;

   public DelayText()
   {



      f = new JFrame("Example");   
      l = new JLabel();

      f.add(l);

      f.setSize(450, 200);

      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


      f.setVisible(true);


      TimerListener tl = new TimerListener();

      t = new Timer(100, tl);

      t.start();




   }

   public static void main(String[] args)
   {

      DelayText d = new DelayText();

   }

   private class TimerListener implements ActionListener
   {

      public void actionPerformed(ActionEvent e)
      {

         if(i < example.length())
         {

            transfer += (example.charAt(i));
            l.setText(transfer);
            i++;



         }

         if(i >= example.length())
         {

            t.stop();

         }



      }

   }

}
import javax.swing.JTextField;
import java.awt.Color;
import java.util.Random;

public class SOQ10
{
   public void something()
   {
      String[] box = new String[]{"box1", "box2", "box3", "box4", "box5", "box6", 
         "box7", "box8", "box9"};

      JTextField[] boxes = new JTextField[9];

      for(int i = 0; i < 9; i++)
      {
         boxes[i] = new JTextField(box[i]);          
      }

      Random rand = new Random();
      int randomint = rand.nextInt(9);
      boxes[randomint].setBackground(Color.yellow);
   }
}
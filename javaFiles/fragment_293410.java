import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Nice extends JFrame implements ActionListener{
  JLabel n1 = new JLabel("1");
  JLabel n2 = new JLabel("2");
  JLabel n3 = new JLabel("3");
  JLabel n4 = new JLabel("4");
  JLabel n5 = new JLabel("5");
  JButton show = new JButton("Show The Numbers");
  int counter = 1 ;
  boolean started = false;
  javax.swing.Timer timer ;
{
    n1.setVisible(false);
    n2.setVisible(false);
    n3.setVisible(false);
    n4.setVisible(false);
    n5.setVisible(false);
}

public Nice(){
super("Timer");
timer = new javax.swing.Timer(2000,new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent evt)
        {
            hideAllLabels();
            if (counter == 1)
            {
                n1.setVisible(true);
                counter++;
            }
            else if (counter == 2)
            {
                n4.setVisible(true);
                counter++;
            }
            else if (counter == 3)
            {
                n2.setVisible(true);
                counter++;
            }
            else if (counter == 4)
            {
                n5.setVisible(true);
                counter++;
            }
            else if (counter == 5)
            {
                n3.setVisible(true);
                counter++;
                timer.stop();
            }
        }
    });
timer.setInitialDelay(0);
timer.setDelay(2000);
timer.setRepeats(true);
setVisible(true);setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(200, 200);
setLayout(new GridLayout(3,3));
add(n1);
add(n2);         
add(n3);
add(n4);
add(n5);
add(show);
show.addActionListener(this);
}
private void hideAllLabels()
{
    n1.setVisible(false);
    n2.setVisible(false);
    n3.setVisible(false);
    n4.setVisible(false);
    n5.setVisible(false);
}
public void actionPerformed(ActionEvent a){
  Object clicked = a.getSource();
  if (show == clicked)
  {    
      if (!timer.isRunning())
      {
          if (!started)
          {
            timer.start();
            started = true;
          }
          else
          {
              counter = 1;
              timer.restart();
          }

      }
  }
}
}
public class NiceOpener{
  public static void main(String[] args){
    Nice frame = new Nice();
    frame.setVisible(true);
  }
}
import java.applet.Applet;
import java.awt.event.*;
import java.awt.*;

/*
<applet code = "Demo.class" width = 400 height = 200> </applet>
*/

public class Demo extends Applet implements ActionListener{
  TextField tf;
  Button draw;
  String shape = "rectangle";//drawing rectangle by default

  public void init(){
    tf = new TextField(10);
    draw = new Button("Draw");
    draw.addActionListener(this);
    add(tf);
    add(draw);
  }

  public void actionPerformed(ActionEvent e) {
    shape = tf.getText();
    repaint();
  }

  public void paint(Graphics g){
    super.paint(g);
    if (shape.equals("rectangle") || shape.equals("RECTANGLE"))
    {
      g.drawRect(30,30,50,60);
    }
    if (shape.equals("circle") || shape.equals("CIRCLE"))
    {
      g.drawOval(30, 30, 50, 60);
    }
    else
    {
      //notify to enter the correct input
    }
  }
}
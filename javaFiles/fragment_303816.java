import java.awt.*;
import java.awt.event.*;

public class Event extends Frame {
 TextField tf, tf1, tf2;
 Event()
 {
  tf=new TextField();
  tf.setBounds(60,50,170,20);
  tf1=new TextField();
  tf1.setBounds(60,70,170,20);
  tf2=new TextField();
  tf2.setBounds(60,90,170,20);
  Button b=new Button("Subtraction");
  b.setBounds(100,120,80,30);
  b.addActionListener(new ActionListener()
  { 
  public void actionPerformed(ActionEvent e)
  {
  int num1 = Integer.parseInt(tf.getText());
  int num2 = Integer.parseInt(tf1.getText());

   tf2.setText(Integer.toString(num1 - num2));
  }
   });
  Button b1=new Button("Division");
  b1.setBounds(100,160,80,30);
  b1.addActionListener(new ActionListener()
  {
  public void actionPerformed(ActionEvent e)
  {
  int num1 = Integer.parseInt(tf.getText());
  int num2 = Integer.parseInt(tf1.getText());

   tf2.setText(Integer.toString(num1 / num2));
  }
   });

  add(b);
  add(b1);
  add(tf);
  add(tf1);
  add(tf2);
  setSize(300,300);
  setLayout(null);
  setVisible(true);
 }

 public static void main(String args[])
 {
  new Event();
 }
}
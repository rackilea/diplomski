import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ControlledBall extends JPanel{

int diameter = 30;
int height = 30;
int x_Pos = 0;
int y_Pos;

ControlledBall() {
  JFrame fr = new JFrame("Controlled Ball");
  fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setBackground(Color.red);    
  setPreferredSize(new Dimension(400,300));
  fr.add(this);
  fr.setVisible(true);
  // important!
  fr.pack();
  //fr.setSize(600,400);
  y_Pos = this.getHeight()/2;
  register();
  repaint();
}

public void register() {
    // very important!
    setFocusable(true);
  this.addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent ke) {
       if( ke.getKeyCode() == ke.VK_RIGHT ) {
           increment();
       }
   else  if( ke.getKeyCode() == ke.VK_LEFT ) {
           decrement();
       }
       else if( ke.getKeyCode() == ke.VK_UP) {
           jump();
       }
    }
 });
}

public void paintComponent(Graphics g) {
 super.paintComponent(g);
 g.setColor( Color.orange );
 g.fillOval( x_Pos , y_Pos , diameter , height );
}

public void increment() {
 x_Pos++;
  if( x_Pos > (this.getWidth() - diameter) ) {
    x_Pos = this.getWidth() - diameter;
  }
 repaint();
}

public void decrement() {
 x_Pos--;
  if( x_Pos <= 0) {
    x_Pos = 0;
  }
 repaint();
}

public void jump() {
 y_Pos++;
  if( y_Pos <=0 ) {
   y_Pos = 0;
 }
repaint();
}

  public static void main( String args[] ) {
    new ControlledBall();
  }
}
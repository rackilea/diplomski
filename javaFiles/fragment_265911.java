import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class EgToMove extends JApplet
              implements KeyListener, FocusListener, MouseListener {

static final int SQUARE_SIZE = 40;
int squareTop, squareLeft;

boolean focussed = false; 
DisplayPanel canvas;

public void init() {


  squareTop = getSize().height / 2 - SQUARE_SIZE / 2;
  squareLeft = getSize().width / 2 - SQUARE_SIZE / 2;


  canvas = new DisplayPanel();  
  setContentPane(canvas);     

  canvas.setBackground(Color.BLACK);
  canvas.addFocusListener(this);   // Set up the applet to listen for events
  canvas.addKeyListener(this);   
  canvas.addMouseListener(this);

  } 

 public void keyTyped(KeyEvent e) {
  //do nothing, if u want something
 }

class DisplayPanel extends JPanel {

  public void paintComponent(Graphics g) {

     super.paintComponent(g);  

     if (focussed)
        g.setColor(Color.cyan);
     else
        g.setColor(Color.lightGray);

     int width = getSize().width;  
     int height = getSize().height; 
     g.drawRect(0,0,width-1,height-1);
     g.drawRect(1,1,width-3,height-3);
     g.drawRect(2,2,width-5,height-5);
     g.fillRect(squareLeft, squareTop, SQUARE_SIZE, SQUARE_SIZE);



     if (!focussed) {
        g.setColor(Color.magenta);
        g.drawString("Click to activate",7,20);
     }
  }  
  }

  // --------- Event handling methods

  public void focusGained(FocusEvent evt) {

  focussed = true;
  canvas.repaint();  // redraw with cyan border ///may b u had problem here
  }

  public void focusLost(FocusEvent evt) {

  focussed = false;
  canvas.repaint();  // redraw without cyan border///may b u had problem here
  }



  public void keyPressed(KeyEvent evt) {


  int key = evt.getKeyCode();  // keyboard code for the key that was pressed

  if (key == KeyEvent.VK_LEFT) {
     squareLeft -= 8;
     if (squareLeft < 3)
        squareLeft = 3;
     canvas.repaint();
  }
  else if (key == KeyEvent.VK_RIGHT) {
     squareLeft += 8;
     if (squareLeft > getSize().width - 3 - SQUARE_SIZE)
        squareLeft = getSize().width - 3 - SQUARE_SIZE;
     canvas.repaint();
  }
  else if (key == KeyEvent.VK_UP) {
     squareTop -= 8;
     if (squareTop < 3)
        squareTop = 3;
     canvas.repaint();
  }
  else if (key == KeyEvent.VK_DOWN) {
     squareTop += 8;
     if (squareTop > getSize().height - 3 - SQUARE_SIZE)
        squareTop = getSize().height - 3 - SQUARE_SIZE;
     canvas.repaint();
  }

  } 


 public void keyReleased(KeyEvent evt) {
  // empty method, required by the KeyListener Interface
 }


 public void mousePressed(MouseEvent evt) {
    // Request that the input focus be given to the
    // canvas 
  canvas.requestFocus();
 }


 public void mouseEntered(MouseEvent evt) { }
 public void mouseExited(MouseEvent evt) { }
 public void mouseReleased(MouseEvent evt) { }
 public void mouseClicked(MouseEvent evt) { }


 }
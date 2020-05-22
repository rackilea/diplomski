import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Temp extends JPanel{
     int pX=200, pY=150;
     Dimension preferredSize = new Dimension(500,300);
    public Temp(){
        addKeyListener(new KeyAdapter() {
         int xPos = 0, playerFace = 4,xPPos = 200, yPPos = 150;

         public void keyPressed(KeyEvent e) {
             int keyCode = e.getKeyCode();
             if (keyCode == e.VK_RIGHT) {
                 if (xPos <= 3250) 
                   if (((xPos + xPPos) >= 825) && ((xPos + xPPos) <= 910)
                           && (yPPos >= 170) && (yPPos <= 255)) {
                   } else if (((xPos + xPPos) >= 1325) && ((xPos + xPPos)<= 1410)
                           && (yPPos >= 170) && (yPPos <= 255)) {
                   } else
                       xPos += 5;
               }
               refreshXY(xPPos+xPos,yPPos);
           }
        });

        setFocusable(true);
        requestFocus();
    }

    public Dimension getPreferredSize(){
        return preferredSize;
    }

     public void updateScreen(){
         repaint();
     }
     public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawString("x:"+pX, 0, 20);
         g.drawString("y:"+pY, 0, 40);       
     }
     public void refreshXY(int x, int y){
         pX=x;
         pY=y;
         System.out.println("Refreshed X&Y");
         updateScreen();
     }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Temp());
        frame.pack();
        frame.setVisible(true);
    }
 }
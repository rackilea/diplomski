// import an extra class for the MouseListener 
import java.awt.event.*;

public class YourClassName extends Applet implements MouseListener 
{
     int x = horizontal position;
     int y = vertical position;
     g.fillRect(x,y,width,height);
     addMouseListener(this); 

     // These methods always have to present when you implement MouseListener
     public void mouseClicked (MouseEvent mouseEvent) {} 
     public void mouseEntered (MouseEvent mouseEvent) {} 
     public void mousePressed (MouseEvent mouseEvent) {} 
     public void mouseReleased (MouseEvent mouseEvent) {}  
     public void mouseExited (MouseEvent mouseEvent) {}  

     public void mouseClicked (MouseEvent mouseEvent) {
     mouseX = mouseEvent.getX();
     mouseY = mouseEvent.getY();
     if(mouseX > x && mouseY > y && mouseX < x+width && mouseY < y+height){
         //
         // do whatever 
         //
     }
}
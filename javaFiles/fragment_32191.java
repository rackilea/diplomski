public class MyFrame extends JFrame implements MouseListener{

   /** Number of times the mouse was clicked */
   private int clicks = 0;

   public MyFrame () 
   {
      this.addMouseListener(this);
   }

   public void mouseClicked(MouseEvent e) 
   { 
       //Increment click count
       clicks++;
   }

   public void mouseEntered(MouseEvent e) {}
   public void mouseExited(MouseEvent e) {}
   public void mousePressed(MouseEvent e){}    
   public void mouseReleased(MouseEvent e)  { }

}
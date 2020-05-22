/*This part of the code is from another class.*/
public class P extends JPanel {
     static P g = new P();

     @Override
     public Dimension getPreferredSize(){
         return new Dimension(requiredWidth , requiredHeight);
     }

     public void paintComponent(Graphics g) {
         super.paintComponent(g);

         g.drawLine(100, 0, 100, 300);
         g.drawLine(200, 0, 200, 300);
         g.drawLine(300, 0, 300, 300);
    }
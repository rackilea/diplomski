frame.pack();
   ...

   public class DragMyIcon extends JPanel {
       ...
       @Override
       public Dimension getPreferredSize() {
           return new Dimension(400, 600);
       }
   }
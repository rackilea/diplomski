import java.awt.*;

import javax.swing.*;

public class ClassA {
   protected final static int dimesionsY = 800;
   protected final static int dimesionsX = 1000; //!!
   private static JFrame window;
   private static JLayeredPane layeredPane;

   public void init() {
      window = new JFrame("Foo");
      // !! dimesionsX = // some user input

      //!! window.setPreferredSize(new Dimension(dimesionsX, dimesionsY));
      window.setLayout(new BorderLayout());

      layeredPane = new JLayeredPane();
      //!! layeredPane.setBounds(0, 0, dimesionsX, dimesionsY);
      layeredPane.setPreferredSize(new Dimension(dimesionsX, dimesionsY));
      window.add(layeredPane, BorderLayout.CENTER);

      ClassB myGraphic = new ClassB();
      myGraphic.drawGraphic();

      myGraphic.setSize(layeredPane.getPreferredSize());
      myGraphic.setLocation(0, 0);
      //!! layeredPane.add(myGraphic, new Integer(0), 0);
      layeredPane.add(myGraphic, JLayeredPane.DEFAULT_LAYER);

      window.pack();
      window.setVisible(true);
   }

   public static void main(String[] args) {
      new ClassA().init();
   }
}

class ClassB extends JPanel {
   public void drawGraphic() {
      repaint();
   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);

      g.setColor(Color.BLACK);
      g.fillRect(10, 10, 100, 100);
   }
}
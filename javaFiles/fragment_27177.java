import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Kreis extends JPanel {
   protected int dia = 20;
   protected int sep = 40;

   public Kreis() {

      // Set JFrame size
      setPreferredSize(new Dimension(500, 500));
      setBackground(Color.green);
   }

   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);

      Dimension d = getSize();

      g.setColor(Color.BLUE);
      for (int y = 0; y < d.height; y += sep) {
         for (int x = 0; x < d.width; x += sep) {
            // draw circle
            g.fillOval(x, y, dia, dia);
         }
      }
   }

   public static void main(final String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            // Create and set up the window.
            JFrame jf = new JFrame();

            Kreis panel = new Kreis();
            jf.add(panel);
            jf.pack();
            jf.setVisible(true);
            jf.addWindowListener(new WindowAdapter() {
               @Override
               public void windowClosing( WindowEvent arg0) {
                  System.exit(0);
               }
            });
         }
      });
   }
}
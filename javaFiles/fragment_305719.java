import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Background extends JPanel {
   Color drawColor = Color.BLACK;
   private final int delay = 150;


   public Background() {
   //   repaint();
      ActionListener action = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {

            Color color = new Color((int) (Math.random() * 256f), (int) (Math.random() * 256f), (int) (Math.random() * 256f));
            drawColor = color;
         }
      };

      Timer t = new Timer(delay, action);
      t.setRepeats(true);
      t.setInitialDelay(0);
      t.start();
   }

   public void render(Graphics g, GameCanvas gameCanvas){
      g.setColor(drawColor);
      g.fillRect(gameCanvas.getX(), gameCanvas.getY(), gameCanvas.getWidth(), gameCanvas.getHeight());
   }
}
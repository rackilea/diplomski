import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import javax.swing.*;

public class BackgroundPanel extends JPanel {
   private static final int PREF_W = 800;
   private static final int PREF_H = 600;
   private static final Font PROMPT_FONT = new Font(Font.SANS_SERIF, Font.BOLD,
         24);
   private Paint gradientPaint;
   private JTextField textField = new JTextField(20);

   public BackgroundPanel() {
      int red = (int) (Math.random() * 256);
      int green = (int) (Math.random() * 256);
      int blue = (int) (Math.random() * 256);
      Color color1 = new Color(red, green, blue);
      red = (int) (Math.random() * 256);
      green = (int) (Math.random() * 256);
      blue = (int) (Math.random() * 256);
      Color color2 = new Color(red, green, blue);

      gradientPaint = new GradientPaint(0, 0, color1, 20, 20, color2, true);

      JLabel promptLabel = new JLabel("Input:");
      promptLabel.setFont(PROMPT_FONT);
      add(promptLabel);
      add(textField);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setPaint(gradientPaint);
      g.fillRect(0, 0, getWidth(), getHeight());
      g.setColor(Color.black);
      g.setFont(PROMPT_FONT);
      g.drawString("Arvaa sana", 100, 100);
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      BackgroundPanel mainPanel = new BackgroundPanel();

      JFrame frame = new JFrame("BackgroundPanel");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}
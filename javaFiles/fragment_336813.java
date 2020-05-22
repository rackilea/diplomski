import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DarkBackground extends JPanel {
   private static final Dimension MAIN_SIZE = new Dimension(800, 500);
   private static final Color DarkColor = new Color(0, 0, 0, 60);
   private JComponent glassPane;

   public DarkBackground() {
      JButton showDialogBtn = new JButton("Show Dialog");
      showDialogBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            setGlassPaneVisible(true);
            JOptionPane.showMessageDialog(DarkBackground.this, "Foo");
            setGlassPaneVisible(false);
         }
      });
      add(showDialogBtn);
      setPreferredSize(MAIN_SIZE);

   }

   public void setGlassPane(JComponent glassPane) {
      JRootPane rootpane = SwingUtilities.getRootPane(this);
      this.glassPane = glassPane; 

      rootpane.setGlassPane(glassPane);
   }

   public void setGlassPaneVisible(boolean visible) {
      glassPane.setVisible(visible);
   }

   private static void createAndShowUI() {
      DarkBackground darkBgrd = new DarkBackground();
      JFrame frame = new JFrame("DarkBackground");
      frame.getContentPane().add(darkBgrd);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      darkBgrd.setGlassPane(new MyGlassPane(DarkColor));
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}

class MyGlassPane extends JComponent {
   private Color backgroundColor;

   public MyGlassPane(Color backgroundColor) {
      this.backgroundColor = backgroundColor;
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(backgroundColor);
      g.fillRect(0, 0, getWidth(), getHeight());
   }
}
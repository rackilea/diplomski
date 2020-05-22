import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class LayeredPaneFun extends JPanel {
   public static final String IMAGE_PATH = "http://duke.kenai.com/" +
        "misc/Bullfight.jpg";

   public LayeredPaneFun() {
      try {
         BufferedImage img = ImageIO.read(new URL(IMAGE_PATH));
         ImageIcon icon = new ImageIcon(img);
         JLabel backgrndLabel = new JLabel(icon);
         backgrndLabel.setSize(backgrndLabel.getPreferredSize());

         JPanel forgroundPanel = new JPanel(new GridBagLayout());
         forgroundPanel.setOpaque(false);

         JLabel fooLabel = new JLabel("Foo");
         fooLabel.setFont(fooLabel.getFont().deriveFont(Font.BOLD, 32));
         fooLabel.setForeground(Color.cyan);
         forgroundPanel.add(fooLabel);
         forgroundPanel.add(Box.createRigidArea(new Dimension(50, 50)));
         forgroundPanel.add(new JButton("bar"));
         forgroundPanel.add(Box.createRigidArea(new Dimension(50, 50)));
         forgroundPanel.add(new JTextField(10));
         forgroundPanel.setSize(backgrndLabel.getPreferredSize());

         JLayeredPane layeredPane = new JLayeredPane();
         layeredPane.setPreferredSize(backgrndLabel.getPreferredSize());
         layeredPane.add(backgrndLabel, JLayeredPane.DEFAULT_LAYER);
         layeredPane.add(forgroundPanel, JLayeredPane.PALETTE_LAYER);

         setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
         add(new JScrollPane(new JTextArea("Output", 10, 40)));
         add(layeredPane);

      } catch (MalformedURLException e) {
         e.printStackTrace();
         System.exit(1);
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(1);
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("LayeredPaneFun");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new LayeredPaneFun());
      frame.pack();
      frame.setLocationRelativeTo(null);
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
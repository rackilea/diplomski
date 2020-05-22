import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainFrame {

   private static final String IMAGE_PATH = "imgFolder/ham-hamster.jpg";

   public static void createGUI() {
      JFrame frame = new JFrame("Fubars");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      File imageFile = new File(IMAGE_PATH);
      try {
         JTextArea textArea = new JTextArea(5, 40);
         textArea.setWrapStyleWord(true);
         textArea.setLineWrap(true);
         for (int i = 0; i < 30; i++) {
            textArea.append("foo bars rule the world!\n");
         }
         textArea.setFont(textArea.getFont().deriveFont(Font.BOLD, 20));
         JScrollPane scrollPane = new JScrollPane(textArea);
         scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
         scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

         textArea.setOpaque(false);
         scrollPane.setOpaque(false);
         scrollPane.getViewport().setOpaque(false);

         BufferedImage backgroundImg = ImageIO.read(imageFile);
         Icon backgroundIcon = new ImageIcon(backgroundImg);
         JLabel contentLabel = new JLabel(backgroundIcon);
         contentLabel.setLayout(new BorderLayout());
         contentLabel.add(scrollPane, BorderLayout.CENTER);
         frame.setContentPane(contentLabel);
         frame.pack();
         frame.setVisible(true);
      } catch (IOException e) {
         e.printStackTrace();
      }

   }

   public static void main(String[] args) {
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createGUI();
         }
      });
   }
}
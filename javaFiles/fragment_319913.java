import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class FoodCounter2 extends JPanel {
   public static final String IMAGE_PATH = "https://duke.kenai.com/iconSized/duke.gif";
   private static final Font TITLE_FONT = new Font("Dialog", Font.PLAIN, 18);
   private JLabel titleLabel = new JLabel("Welcome, User", SwingConstants.CENTER);
   private JButton backButton = new JButton("Back");
   private JButton addFoodButton = new JButton("+ Food");
   private JLabel foodCountLabel = new JLabel("0/100 Food");

   public FoodCounter2() throws IOException {
      URL imgUrl = new URL(IMAGE_PATH);
      BufferedImage img = ImageIO.read(imgUrl);
      ImageIcon icon = new ImageIcon(img);

      JPanel foodPanel = new JPanel(new GridBagLayout());
      // JPanel foodPanel = new JPanel();
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.insets = new Insets(10, 10, 10, 10);
      foodPanel.add(new JLabel("Click to Begin! --->"), gbc);
      gbc.gridx++;
      foodPanel.add(addFoodButton, gbc);
      gbc.gridx++;
      foodPanel.add(foodCountLabel, gbc);

      JPanel centerPanel = new JPanel(new BorderLayout());
      titleLabel.setFont(TITLE_FONT);
      centerPanel.add(titleLabel, BorderLayout.PAGE_START);
      centerPanel.add(foodPanel, BorderLayout.CENTER);

      setLayout(new BorderLayout());
      add(backButton, BorderLayout.LINE_START);
      add(centerPanel, BorderLayout.CENTER);
      add(new JLabel(icon), BorderLayout.LINE_END);

   }

   private static void createAndShowGui() {
      FoodCounter2 mainPanel  = null;
      try {
         mainPanel = new FoodCounter2();
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }

      JFrame frame = new JFrame("FoodCounter2");
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
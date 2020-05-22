import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;

public class CartEg extends JPanel {
   private static final long serialVersionUID = 1L;
   private static final int GAP = 10;
   private static final String TITLE_TEXT = "Some Great Title";
   private JTextArea itemArea = new JTextArea(25, 60);

   public CartEg() {
      // create centered title JLabel
      JLabel titleLabel = new JLabel(TITLE_TEXT, SwingConstants.CENTER);
      // make it big and bold
      titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 42f));

      itemArea.setWrapStyleWord(true);
      itemArea.setLineWrap(true);
      JScrollPane scrollPane = new JScrollPane(itemArea);

      JPanel bottomButtonPanel = new JPanel(); // panel to hold JButtons
      bottomButtonPanel.setLayout(new BoxLayout(bottomButtonPanel, BoxLayout.LINE_AXIS));
      bottomButtonPanel.add(new JButton("Left Button"));
      bottomButtonPanel.add(Box.createHorizontalGlue());
      bottomButtonPanel.add(new JButton("Right Button 1"));
      bottomButtonPanel.add(new JButton("Right Button 2"));

      // create some empty space around our components
      setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      // use a BorderLayout for the main JPanel
      setLayout(new BorderLayout(GAP, GAP));

      // add JScrollPane to the BorderLayout.CENTER position
      // add your JPanel that holds buttons to the BorderLayout.PAGE_END
      // and add your title JLabel to the BorderLayout.PAGE_START position

      add(scrollPane, BorderLayout.CENTER);
      add(titleLabel, BorderLayout.PAGE_START);
      add(bottomButtonPanel, BorderLayout.PAGE_END);


   }

   private static void createAndShowGui() {
      CartEg mainPanel = new CartEg();

      JFrame frame = new JFrame("Cart Example");
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
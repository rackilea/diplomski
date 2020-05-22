import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class TestTextArea2 extends JPanel {

   private static final Color BG = Color.LIGHT_GRAY;
   private static final int ROWS = 14;
   private static final int COLS = 34;
   private JTextArea textArea = new JTextArea(ROWS, COLS);

   public TestTextArea2(int heightGap, int sideGap) {
      setBorder(BorderFactory.createEmptyBorder(heightGap, sideGap, heightGap, sideGap));

      textArea.setBackground(Color.LIGHT_GRAY);
      JScrollPane scrollPane = new JScrollPane(textArea);

      JPanel txtAreaPanel = new JPanel(); 
      int ebGap = 40;
      txtAreaPanel.setBackground(Color.white);
      txtAreaPanel.setBorder(BorderFactory.createEmptyBorder(ebGap, ebGap, ebGap, ebGap));
      txtAreaPanel.setLayout(new GridBagLayout());
      txtAreaPanel.add(scrollPane);

      JPanel myPanel2 = new JPanel();
      Border outerBorder = BorderFactory.createEtchedBorder();
      int heightGap2 = 5;
      int sideGap2 = 5;
      Border innerBorder = BorderFactory.createEmptyBorder(heightGap2, sideGap2, heightGap2, sideGap2);
      myPanel2.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

      myPanel2.setLayout(new GridBagLayout());
      myPanel2.add(txtAreaPanel);

      setBackground(BG);
      setLayout(new GridBagLayout());
      add(myPanel2);
   }


   private static void createAndShowGui() {
      JFrame frame = new JFrame("TestTextArea2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new TestTextArea2(100, 100));
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
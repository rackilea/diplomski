import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
   private static final int PREF_W = 450;
   private static final int PREF_H = 300;
   private static final int GAP = 5;
   private static final int TAB_COUNT = 5;

   private JTabbedPane tabbedPane = new JTabbedPane();

   public MainPanel() {
      for (int i = 0; i < TAB_COUNT; i++) {
         JPanel panel = new JPanel();
         panel.add(new JButton("Button " + (i + 1)));
         panel.setName("Panel " + (i + 1));
         tabbedPane.add(panel.getName(), panel);         
      }

      setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      setLayout(new BorderLayout());
      add(tabbedPane, BorderLayout.CENTER);

      tabbedPane.getModel().addChangeListener(new ChangeListener() {

         @Override
         public void stateChanged(ChangeEvent evt) {
            Component component = tabbedPane.getSelectedComponent();
            System.out.println("Component Selected: " + component.getName());
         }
      });
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      MainPanel mainPanel = new MainPanel();

      JFrame frame = new JFrame("MainPanel");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class DisableEg extends JPanel {
   public static final String DISABLE_DIALOG_COMPONENTS = "Disable Dialog Components";
   public static final String ENABLE_DIALOG_COMPONENTS = "Enable Dialog Components";
   public static final String DISABLE_DIALOG = "Disable Dialog";
   public static final String ENABLE_DIALOG = "Enable Dialog";
   private static final int LOC_SHIFT = 150;
   private Analyzer analyzer;

   public DisableEg(JFrame frame) {
      analyzer = new Analyzer(frame);
      analyzer.pack();
      analyzer.setLocationRelativeTo(frame);
      Point location = analyzer.getLocation();
      location = new Point(location.x - LOC_SHIFT, location.y - LOC_SHIFT);
      analyzer.setLocation(location);
      analyzer.setVisible(true);

      add(new JButton(new AbstractAction(DISABLE_DIALOG_COMPONENTS) {

         @Override
         public void actionPerformed(ActionEvent evt) {
            AbstractButton btn = (AbstractButton) evt.getSource();
            if (btn.getText().equals(DISABLE_DIALOG_COMPONENTS)) {
               btn.setText(ENABLE_DIALOG_COMPONENTS);
               analyzer.setComponentEnabled(false);
            } else {
               btn.setText(DISABLE_DIALOG_COMPONENTS);
               analyzer.setComponentEnabled(true);
            }
         }
      }));
      add(new JButton(new AbstractAction(DISABLE_DIALOG) {

         @Override
         public void actionPerformed(ActionEvent evt) {
            AbstractButton btn = (AbstractButton) evt.getSource();
            if (btn.getText().equals(DISABLE_DIALOG)) {
               btn.setText(ENABLE_DIALOG);
               analyzer.setEnabled(false);
            } else {
               btn.setText(DISABLE_DIALOG);
               analyzer.setEnabled(true);
            }
         }
      }));
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("Disable Example");
      DisableEg mainPanel = new DisableEg(frame);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
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

@SuppressWarnings("serial")
class Analyzer extends JDialog {

   public Analyzer(JFrame frame) {
      super(frame, "Analyzer Dialog", false);
      JButton but = new JButton("test");
      setLayout(new FlowLayout());

      add(but);
      setPreferredSize(new Dimension(200, 200));
   }

   public void setComponentEnabled(boolean enabled) {
      setComponentEnabled(enabled, getContentPane());

      // !! if you have menus to disable, you may need instead
      // setComponentEnabled(enabled, this); // !!
   }

   private void setComponentEnabled(boolean enabled, Component component) {
      component.setEnabled(enabled);
      if (component instanceof Container) {
         Component[] components = ((Container) component).getComponents();
         if (components != null && components.length > 0) {
            for (Component heldComponent : components) {
               setComponentEnabled(enabled, heldComponent);
            }
         }
      }
   }

}
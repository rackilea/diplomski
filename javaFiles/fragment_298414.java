import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class NoneInARowBtns {
   private static void createAndShowGui() {
      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 0));
      NoRepeatButtonGroup noRepeatButtonGroup = new NoRepeatButtonGroup();

      int buttonCount = 5;
      for (int i = 0; i < buttonCount; i++) {
         JButton btn = new JButton(new ButtonAction(i + 1));
         noRepeatButtonGroup.add(btn);
         buttonPanel.add(btn);
      }

      JOptionPane.showMessageDialog(null, buttonPanel);

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
class ButtonAction extends AbstractAction {
   public ButtonAction(int i) {
      super("Button " + i);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      System.out.println(e.getActionCommand() + " Pressed");
   }
}

class NoRepeatButtonGroup implements ActionListener {
   private List<AbstractButton> btnList = new ArrayList<>();

   public void add(AbstractButton btn) {
      btnList.add(btn);
      btn.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent evt) {
      for (AbstractButton btn : btnList) {
         btn.setEnabled(true);
      }
      ((AbstractButton) evt.getSource()).setEnabled(false);
   }

   public void reset() {
      for (AbstractButton btn : btnList) {
         btn.setEnabled(true);
      }
   }
}
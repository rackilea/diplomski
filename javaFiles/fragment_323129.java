import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.border.*;

public class Foo {
   static CompoundBorder lowered; // = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
   static CompoundBorder raised; // = BorderFactory.createBevelBorder(BevelBorder.RAISED);

   public static void main(String[] args) {

      JPanel panel = new JPanel();

      final ButtonGroup btnGrp = new ButtonGroup();
      for (int i = 0; i < 4; i++) {
         JToggleButton toggle = new JToggleButton("Toggle " + (i + 1));
         if (lowered == null) {
            CompoundBorder toggleBorder = (CompoundBorder) toggle.getBorder();
            Border toggleInside = toggleBorder.getInsideBorder();
            lowered = BorderFactory.createCompoundBorder(
                  BorderFactory.createBevelBorder(BevelBorder.LOWERED),
                  toggleInside);
            raised = BorderFactory.createCompoundBorder(
                  BorderFactory.createBevelBorder(BevelBorder.RAISED),
                  toggleInside);
         }
         toggle.setBorder(raised);
         btnGrp.add(toggle);
         panel.add(toggle);
         toggle.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent iEvt) {
               Border border = iEvt.getStateChange() == ItemEvent.SELECTED ? lowered
                     : raised;
               ((JComponent) iEvt.getSource()).setBorder(border);
            }

         });
      }

      JOptionPane.showMessageDialog(null, panel);

   }

}
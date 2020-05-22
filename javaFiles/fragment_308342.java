import java.awt.event.ActionEvent;
import javax.swing.*;

public class McvMenu {
   private JMenuBar menuBar = new JMenuBar();
   private MvcControl control;

   @SuppressWarnings("serial")
   public McvMenu(MvcControl cntrl) {
      this.control = cntrl;

      JMenu menu = new JMenu("Change State");
      menu.add(new JMenuItem(new AbstractAction("Start") {
         public void actionPerformed(ActionEvent ae) {
            if (control != null) {
               control.startButtonActionPerformed(ae);
            }
         }
      }));
      menu.add(new JMenuItem(new AbstractAction("End") {
         public void actionPerformed(ActionEvent ae) {
            if (control != null) {
               control.endButtonActionPerformed(ae);
            }
         }
      }));

      menuBar.add(menu);
   }

   public JMenuBar getMenuBar() {
      return menuBar;
   }
}
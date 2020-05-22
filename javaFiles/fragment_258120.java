import java.awt.Dimension;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class AppletCentering extends JApplet {
    @Override
    public void init() {
        final JPanel panel = new JPanel();
        panel.add(new JButton(new AbstractAction("Press Me") {

            @Override
            public void actionPerformed(ActionEvent e) {
                Window win = SwingUtilities.getWindowAncestor(panel);
                System.out.println("win class: " + win.getClass().getCanonicalName());
                JDialog dialog = new JDialog(win, "My Dialog", ModalityType.APPLICATION_MODAL);
                dialog.add(Box.createRigidArea(new Dimension(200, 200)));
                dialog.pack();
                dialog.setLocationRelativeTo(win);
                dialog.setVisible(true);                    
            }
        }));

        add(panel);
    }
}
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class CloseDialog implements Runnable {

    private final AWTEventListener hideOptionPaneListener = new AWTEventListener() {

        @Override
        public void eventDispatched(AWTEvent event) {
            if (event instanceof WindowEvent) {
                processWindowEvent((WindowEvent) event);
            }
        }
    };

    private void processWindowEvent(WindowEvent we) {
        if (we.getID() == WindowEvent.WINDOW_OPENED && we.getWindow() instanceof JDialog) {
            final JDialog dlg = (JDialog) we.getWindow();
            Component[] comps = dlg.getContentPane().getComponents();
            if (comps.length > 0 && comps[0] instanceof JOptionPane) { // probably also check dialog title
                dlg.setVisible(false);
            }
        }
    }

    @Override
    public void run() {
        final JFrame frm = new JFrame("Test frame");
        JButton button = new JButton("Show option pane");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frm, "Simple message");
            }
        });
        final JCheckBox checkBox = new JCheckBox("Suppress option pane");
        checkBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    Toolkit.getDefaultToolkit().addAWTEventListener(hideOptionPaneListener, AWTEvent.WINDOW_EVENT_MASK);
                } else {
                    Toolkit.getDefaultToolkit().removeAWTEventListener(hideOptionPaneListener);
                }
            }
        });
        JPanel top = new JPanel(new FlowLayout());
        top.add(button);
        frm.add(top, BorderLayout.NORTH);
        frm.add(checkBox, BorderLayout.SOUTH);
        frm.setSize(400, 200);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new CloseDialog());
    }
}
import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class AreWeReady extends JPanel {
    List<AbstractButton> buttons = new ArrayList<>();
    private int userCount;

    public AreWeReady(int userCount) {
        this.userCount = userCount;
        ButtonListener buttonListener = new ButtonListener();
        for (int i = 0; i < userCount; i++) {
            JButton btn = new JButton("User " + (i + 1));
            buttons.add(btn);
            btn.addActionListener(buttonListener);
            add(btn);
        }
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AbstractButton btn = (AbstractButton) e.getSource();
            Color c = Color.GREEN.equals(btn.getBackground()) ? null : Color.GREEN;
            btn.setBackground(c);

            for (AbstractButton button : buttons) {
                if (!Color.GREEN.equals(button.getBackground())) {
                    // if any button does not have a green background
                    return;    // leave this method
                }
            }

            // otherwise if all are green, we're here
            Window win = SwingUtilities.getWindowAncestor(btn);
            win.dispose();
            // else launch your gui
        }
    }

    private static void createAndShowGui() {
        int userCount = 4;
        AreWeReady areWeReadyPanel = new AreWeReady(userCount);

        JFrame frame = new JFrame("Main Application");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(Box.createRigidArea(new Dimension(400, 300)));
        frame.pack();
        frame.setLocationByPlatform(true);

        JDialog dialog = new JDialog(frame, "Are We Ready?", ModalityType.APPLICATION_MODAL);
        dialog.add(areWeReadyPanel);
        dialog.pack();
        dialog.setLocationByPlatform(true);
        dialog.setVisible(true);

        // this is only reached when the modal dialog above is no longer visible
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
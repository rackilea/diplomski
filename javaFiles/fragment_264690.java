import javax.swing.*;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    // Creates the main frame (MainForm extends JFrame)
    private static MainForm mainForm = new MainForm();

    public static void main(String[] args) {
        mainForm.setVisible(true);
    }

    static class BaseDialog extends JDialog {
        BaseDialog(Window win) {
            super(win);
            setModal(true);
        }

        // Overrides and calls (super)dispose method of JDialog - Nothing
        // unusual
        @Override
        public void dispose() {
            Exception e = new Exception();
            // e.printStackTrace();
            String text = String.format("Disposing. This hashCode: %08X", hashCode());
            System.out.println(text);
            super.dispose();
        }
    }

    static class CaptureDialog extends BaseDialog implements ActionListener {
        CaptureDialog(Window win) {
            super(win);
            JButton btnInventory = new JButton("Close Me");
            btnInventory.addActionListener(this);
            add(btnInventory);
            setTitle("Recapture");
            setModalityType(ModalityType.APPLICATION_MODAL);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setResizable(false);
            setSize(200, 80);
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Clicked the button!");
            dispose();
        }
    }

    static class MainForm extends JFrame implements ActionListener {
        MainForm() {
            super("Example");
            JButton btnCapture = new JButton();
            btnCapture.setText("Capture");
            btnCapture.addActionListener(this);
            add(btnCapture);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setSize(200, 80);
        }

        // Only one button is added to action listener ('if' not necessary)
        @Override
        public void actionPerformed(ActionEvent e) {
            new CaptureDialog(MainForm.this);
        }
    }
}
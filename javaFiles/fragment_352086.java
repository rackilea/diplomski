import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JDialogDemo extends JFrame {

    public JDialogDemo() {

        final MyDialog dialog = new MyDialog(this);

        JButton button = new JButton("Show Dialog");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.pack();
                dialog.setLocationRelativeTo(JDialogDemo.this);

                dialog.setVisible(true);
            }
        });

        setLayout(new FlowLayout());
        add(button);

        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JDialogDemo();
    }
}

class MyDialog extends JDialog {
    public MyDialog(Frame owner) {
        super(owner, true);

        setTitle("About");

        add(new JLabel("<html>Version 2<br><br>" + "Added new features: <br><br>" + "Color Customization<br>"
                + "Different Game Modes<br>" + "Menu Bar<br>" + "Images<br>" + "Sound Effects<br>"
                + "History of Score"));

        JButton okButton = new JButton("Ok");
        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        add(okButton, BorderLayout.SOUTH);
    }

}
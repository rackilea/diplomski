import java.awt.*;
import javax.swing.*;

public class TextFieldInToolBar {

    TextFieldInToolBar() {
        JPanel p = new JPanel(new BorderLayout());

        JToolBar tb = new JToolBar();
        p.add(tb, BorderLayout.PAGE_START);

        Icon disk = (Icon)UIManager.get("FileView.floppyDriveIcon"); 
        Icon pc = (Icon)UIManager.get("FileView.computerIcon"); 
        tb.add(new JButton(disk));
        JTextField tf = new JTextField(3);
        tf.setMaximumSize(tf.getPreferredSize());
        tb.add(tf);
        tb.addSeparator();
        tb.add(new JButton(pc));

        p.setPreferredSize(new Dimension(250,50));

        JOptionPane.showMessageDialog(null, p);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextFieldInToolBar();
            }
        });
    }
}
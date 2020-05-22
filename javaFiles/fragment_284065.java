import javax.swing.*;

class ColorChooserTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, new JColorChooser());
            }
        });
    }
}
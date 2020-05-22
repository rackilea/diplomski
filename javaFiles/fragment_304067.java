import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class TwoButtonLayout {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                // adjust numbers to need..
                JPanel panel = new JPanel(new GridLayout(1, 2, 40, 40));
                // adjust numbers to need..
                panel.setBorder(new EmptyBorder(20,30,20,30));
                panel.setBackground(Color.WHITE);

                JButton but = new JButton("text");
                JButton but2 = new JButton("list");

                panel.add(but);
                panel.add(but2);

                JOptionPane.showMessageDialog(null, panel);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}
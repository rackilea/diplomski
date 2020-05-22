import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class ButtonLabelLayout {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JPanel gui = new JPanel(new BorderLayout());
                gui.setBorder(new TitledBorder("Border Layout"));

                JPanel labels = new JPanel();
                labels.setBorder(new TitledBorder("Flow Layout"));
                labels.add(new JLabel("Label 1"));
                labels.add(new JLabel("Label 2"));

                gui.add(labels, BorderLayout.NORTH);
                gui.add(new JButton("Button"), BorderLayout.SOUTH);

                JOptionPane.showMessageDialog(null, gui);
            }
        });
    }
}
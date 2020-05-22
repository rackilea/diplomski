import java.awt.*;
import javax.swing.*;

class SimpleNestedLayout {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                JPanel gui = new JPanel(new BorderLayout(5,5));

                int sz = 4;
                Container content = new JPanel(new GridLayout(sz, 0, 2, 2));
                for (int f=0; f<sz*sz; f++) {
                    content.add(new JButton());
                }
                gui.add(content, BorderLayout.CENTER);

                Container info = new JPanel(
                        new FlowLayout(FlowLayout.CENTER, 50, 5));
                info.add(new JLabel("Flow"));
                info.add(new JLabel("Layout"));
                gui.add(info, BorderLayout.PAGE_START);

                gui.add(new JLabel("Label"), BorderLayout.LINE_END);

                JOptionPane.showMessageDialog(null, gui);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}
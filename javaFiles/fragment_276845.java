import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.*;

public class StretchComboLayout {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JPanel ui = new JPanel(new BorderLayout(2, 2));
                ui.setBorder(new EmptyBorder(4, 4, 4, 4));

                JPanel controls = new JPanel(new BorderLayout(2, 2));
                ui.add(controls, BorderLayout.PAGE_START);
                String s = new String(Character.toChars(8594));
                String[] items = {"Choice: right " + s + " arrow"};
                JComboBox cb = new JComboBox(items);
                controls.add(cb, BorderLayout.CENTER);
                controls.add(new JButton("Button"), BorderLayout.LINE_END);

                JSplitPane sp = new JSplitPane(
                        JSplitPane.VERTICAL_SPLIT, 
                        new JTextArea(4,40), 
                        new JTextArea(4,40));

                ui.add(sp, BorderLayout.CENTER);

                JFrame f = new JFrame("Stretch Combo Layout");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setContentPane(ui);
                f.pack();
                f.setLocationByPlatform(true);
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}
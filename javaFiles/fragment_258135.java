import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class ClearJtextField {

    public ClearJtextField() {

        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 120, 120));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField tf = new JTextField("Type something and click");
        // adding MouseAdapter and overriding mouseClicked
        tf.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tf.setText("");
            }
        });

        frame.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (tf.getText().length() == 0)
                    tf.setText("Type something and click");

            }

        });

        frame.add(tf);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ClearJtextField();

    }

}
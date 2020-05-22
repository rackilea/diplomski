package htmlmiglayout;

import javax.swing.*;
import net.miginfocom.swing.*;
import java.awt.Dimension;

public class HTMLMigLayout {

    public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   //new
    JPanel panel = new JPanel();
    JLabel htmlLabel = new JLabel();

    panel.setLayout(new MigLayout());
    htmlLabel.setText("<html><body><p>Some LONNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNG LONNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNG LONNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNG LONNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNG LONNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNG TEXT</p></body></html>"); // This is where I put my text.

    panel.add(htmlLabel);

    frame.setPreferredSize(new Dimension(400, 300));
    frame.setMinimumSize(frame.getPreferredSize());
    frame.setMaximumSize(frame.getPreferredSize());
    frame.setLocation(0, 0);

    frame.add(panel);
    frame.setVisible(true);
    }

}
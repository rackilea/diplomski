package to.uk.gagandeepbali.examples;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;

/**
 * Created by Gagandeep Bali on 7/12/2014.
 */
public class FilterCharacters {

    private void displayGUI() {
        JFrame frame = new JFrame("Filtering Text Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        JTextField tField = new JTextField(10);
        ((AbstractDocument)tField.getDocument()).setDocumentFilter(new MyDocumentFilter());
        contentPane.add(tField);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new FilterCharacters().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}
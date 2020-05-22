import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Example {

    public static void main(String args[]) {

        JFrame frame = new JFrame();

        JTextField tf1 = new JTextField(10);

        JTextField tf2 = new JTextField(10);

        JButton b1 = new JButton("Convert to USD");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    tf2.setText("" + findExchangeRateAndConvert("EUR", "USD",Integer.parseInt(tf1.getText())));
                } catch(NumberFormatException nfe) {

                }
            }
        });

        JButton b2 = new JButton("Convert to EUR");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    tf2.setText("" + findExchangeRateAndConvert("USD", "EUR",Integer.parseInt(tf1.getText())));
                } catch(NumberFormatException nfe) {

                }
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(tf1);
        frame.add(b1);
        frame.add(b2);
        frame.add(tf2);
        frame.pack();
        frame.setVisible(true);

    }

    private static Double findExchangeRateAndConvert(String from, String to,
            int amount) {
        try {
            // Yahoo Finance API
            URL url = new URL("http://finance.yahoo.com/d/quotes.csv?f=l1&s="
                    + from + to + "=X");
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    url.openStream()));
            String line = reader.readLine();
            if (line.length() > 0) {
                return Double.parseDouble(line) * amount;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
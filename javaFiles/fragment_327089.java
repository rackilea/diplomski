import java.awt.*;
import javax.swing.*;

class ColoredLabel {

    static String text =
            "<html>"
            + "<head>"
            + "<style type='text/css'>"
            + ".name {"
            + " font-size: 16px;"
            + " color: blue;"
            + "}"
            + ".value {"
            + " font-size: 12px;"
            + " color: green;"
            + "}"
            + "</style>"
            + "</head>"
            + "<body>"
            + "<h1>Orb of Deception</h1>"
            + "<table border=1>"
            + "<tr><td class='name'>Range</td><td class='value'>880</td></tr>"
            + "<tr><td class='name'>Cost</td><td class='value'>70/75/80/85/90 Mana</td></tr>"
            + "<tr><td class='name'>Cooldown</td><td class='value'>7</td></tr>"
            + "</table>"
            + "</body>"
            + "</html>";

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, new JLabel(text));
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}
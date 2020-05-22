import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class HTMLTextColour extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton button;
    private JLabel label;
    private String when = "  asked yesterday  ";
    private String who = "  Vagelism  ";
    private String reputation = "  110 *7  ";
    private String accept = "  86% accept rate  ";

    public HTMLTextColour() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        button = new JButton("Sample text");
        button.setText("<html><font color=" + (button.isEnabled() ? "blue" : "red") + ">"
                + button.getText() + "</font></html>");
        button.getModel().addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();
                if (model.isRollover()) {
                    label.setText(label.getText().replace("<html><strike>",
                            "<html>").replace("</strike></html>", "</html>"));
                } else {
                    label.setText(label.getText().replace("<html>",
                            "<html><strike>").replace("</html>", "</strike></html>"));
                }
                if (model.isPressed()) {
                    when = "   QQQQQQQQQQQQ QQQQQQQQQQQQ:   ";
                    who = "   - wwwwwwwwwww - wwwwwwwwwww   ";
                    reputation = "  - eeeeeeeeeee - eeeeeeeeeee  ";
                    accept = "  - xxxxxxxxxxx - xxxxxxxxxxx  ";
                    label.setText("<html> " + when + " <br>" + " " + who + " <br>"
                            + " " + reputation + " <br>" + " " + accept + " </html> ");
                    pack();
                }
            }
        });
        add(button);
        label = new JLabel("<html> " + when + " <br>"
                + " " + who + " <br>"
                + " " + reputation + " <br>"
                + " " + accept + " </html> ");
        add(label);
        pack();
        setVisible(true);
    }

    public static void main(String argsv[]) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                HTMLTextColour hTMLTextColour = new HTMLTextColour();
            }
        });
    }
}
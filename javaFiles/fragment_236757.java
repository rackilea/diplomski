import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TutoringCalculator {

    private JPanel _root;
    private JPanel swingContainer;
    private JLabel lbl;
    private JTextField txt;

    TutoringCalculator() {
        swingContainer = new JPanel(new BorderLayout());
        // set an empty border to it
        swingContainer.setBorder(new EmptyBorder(20,20,20,20));

        // suggest a spacing of 20px between components
        _root = new JPanel(new FlowLayout( FlowLayout.CENTER, 20, 20));
        swingContainer.add(_root);

        // add a line border so we can see the bounds of this container
        _root.setBorder(new LineBorder(Color.BLACK, 1));

        // this has a size as needed by the content
        lbl = new JLabel("Session Minutes:");
        _root.add(lbl);

        // Suggest a size (in characters - 10) for the text field
        txt = new JTextField(10);
        _root.add(txt);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Tutoring Calculator");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                TutoringCalculator calc = new TutoringCalculator();

                frame.setContentPane(calc.swingContainer);

                frame.pack();
                // much better!
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
            }
        });
    }
}
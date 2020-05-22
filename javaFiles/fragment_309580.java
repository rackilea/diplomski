import java.awt.BorderLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

public class MaskFormatterTest extends JPanel {

    private JFormattedTextField formatText;

    public MaskFormatterTest() {
        formatText = new JFormattedTextField(createFormatter("##:##"));
        formatText.setColumns(20);
        formatText.setText("00:00");

        setLayout(new BorderLayout());
        add(new JLabel("Enter only numbers"), BorderLayout.NORTH);
        add(formatText, BorderLayout.CENTER);
    }

    private MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("MaskFormatter example");
                frame.add(new MaskFormatterTest());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationByPlatform(true);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
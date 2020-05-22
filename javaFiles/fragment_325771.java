import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.text.*;

public class Test {

    private String formatString = "##/######";
    private MaskFormatter formatCNP = createFormatter(formatString);
    private JFormattedTextField jtfCNP = new JFormattedTextField(formatCNP);
    private JFrame frame = new JFrame("MaskFormatter Test");

    public Test() {
        jtfCNP.setColumns(20);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(jtfCNP);
        frame.pack();
        frame.setVisible(true);
    }

    MaskFormatter createFormatter(String format) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(format);
            formatter.setPlaceholderCharacter('.'/*or '0' etc*/);
            formatter.setAllowsInvalid(false); // if needed
            formatter.setOverwriteMode(true); // if needed
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
        }
        return formatter;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Test tf = new Test();
            }
        });
    }
}
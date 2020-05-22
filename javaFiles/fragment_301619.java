import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

public class MaskFormatterTest1 extends JPanel {

    private JFormattedTextField formatText;

    public MaskFormatterTest1() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateString = formatter.format(date);
        formatText = new JFormattedTextField(createFormatter("####-##-## ##:##:##"));
        formatText.setColumns(20);
        formatText.setText(dateString);

        setLayout(new BorderLayout());
        add(new JLabel("Enter Date and Time in YYYY-MM-DD HH:MM:SS format"), BorderLayout.NORTH);
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
                frame.add(new MaskFormatterTest1());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationByPlatform(true);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
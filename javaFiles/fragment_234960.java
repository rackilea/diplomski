import java.awt.EventQueue;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSpinnerTest extends JPanel {

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame("JSpinnerTest");
                f.add(new JSpinnerTest());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setVisible(true);
            }
        });
    }

    public JSpinnerTest() {
        final JLabel label = new JLabel();
        final JSpinner spinner = new JSpinner();
        spinner.setLocale(new Locale("th", "TH"));
        Calendar calendar = Calendar.getInstance();
        Date initDate = calendar.getTime();
        calendar.add(Calendar.YEAR, -5);
        Date earliestDate = calendar.getTime();
        calendar.add(Calendar.YEAR, 10);
        Date latestDate = calendar.getTime();
        spinner.setModel(new SpinnerDateModel(
            initDate, earliestDate, latestDate, Calendar.MONTH));
        spinner.setEditor(new JSpinner.DateEditor(spinner, "MMM yyyy"));
        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSpinner s = (JSpinner) e.getSource();
                label.setText(s.getValue().toString());
            }
        });
        label.setText(initDate.toString());
        this.add(label);
        this.add(spinner);
    }
}
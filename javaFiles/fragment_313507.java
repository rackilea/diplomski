import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

public class SpinnerExample extends JFrame {

    private final JSpinner mySpinner;

    public static void main(String[] args) {
        SpinnerExample main = new SpinnerExample();
    }

    public SpinnerExample() {
        super("SpinnerExample");

        mySpinner = new JSpinner();
        mySpinner.setModel(getMySpinnerModel());
//        mySpinner.setEditor(new JSpinner.DateEditor(mySpinner, "HH:mm"));
        mySpinner.setEditor(new CustomEditor(mySpinner, "HH:mm"));

        add(mySpinner);

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private SpinnerDateModel getMySpinnerModel() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date selectedDate = calendar.getTime();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        Date endDate = calendar.getTime();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        Date startDate = calendar.getTime();
        return new SpinnerDateModel(selectedDate, startDate,
                endDate, Calendar.HOUR);
    }
}

class CustomEditor extends JFormattedTextField implements ChangeListener {

    private final JSpinner spinner;

    public CustomEditor(JSpinner spinner, String pattern) {
        super();
        this.spinner = spinner;
        DateFormatter formatter
                = new DateFormatter(new SimpleDateFormat(pattern));
        formatter.setAllowsInvalid(false);
        formatter.setOverwriteMode(true);
        setFormatterFactory(new DefaultFormatterFactory(formatter));
        updateValue();
        spinner.addChangeListener(this);
        addActionListener((ActionEvent e) -> {
            this.spinner.getModel().setValue(this.getValue());
        });
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        updateValue();
    }

    private void updateValue() {
        setValue((Date) spinner.getModel().getValue());
    }
}
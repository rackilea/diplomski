import java.awt.EventQueue;
import java.util.Calendar;
import javax.swing.*;

public class DemoJDialog {

    public static void main(String[] args) {
        new DemoJDialog();
    }

    public DemoJDialog() {
        EventQueue.invokeLater(new Runnable() {
            @SuppressWarnings({"rawtypes", "unchecked"})
            @Override
            public void run() {
                String example = new String("Some very-very-very-"
                        + "very-very-very-very-very-very "
                        + "long string (really long)");
                // create a textfield the size of the string!
                JTextField inputCat = new JTextField(example);
                inputCat.setCaretPosition(0);

                String[] comboString = {"Telecast", "Radiocast"};
                JComboBox comboBox = new JComboBox(comboString); 

                Calendar now = Calendar.getInstance();
                SpinnerModel modelSpinner = new SpinnerDateModel(now.getTime(),
                        null, null, Calendar.MONTH);
                final JSpinner spinner = new JSpinner(modelSpinner);
                spinner.setEditor(new JSpinner.DefaultEditor(spinner));

                JPanel listPane = new JPanel();
                listPane.setLayout(new BoxLayout(listPane, BoxLayout.X_AXIS));
                listPane.add(comboBox);
                listPane.add(Box.createHorizontalStrut(10));
                listPane.add(inputCat);
                listPane.add(Box.createHorizontalStrut(10));
                listPane.add(spinner);

                Object[] array = {
                    new JLabel("Enter a new category:"),
                    listPane
                };

                JOptionPane pane = new JOptionPane(array, JOptionPane.PLAIN_MESSAGE,
                        JOptionPane.OK_CANCEL_OPTION);
                JDialog dialog = pane.createDialog(listPane, "Enter a new category:");
                dialog.setVisible(true);
            }
        });
    }
}
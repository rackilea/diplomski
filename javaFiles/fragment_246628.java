import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Foo2 extends JPanel {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 8;

    private JSpinner spinner = new JSpinner(new SpinnerNumberModel(MIN_VALUE, MIN_VALUE, MAX_VALUE, 1));
    private List<DefaultComboBoxModel<String>> models = new ArrayList<>();
    private JComboBox<String> comboBox = new JComboBox<>();

    public Foo2() {
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>();
            for (int j = 0; j < 5; j++) {
                String element = String.format("Selection: %d, Item: %d", i, j);
                comboModel.addElement(element);
            }
            models.add(comboModel);
        }
        comboBox.setModel(models.get(0));

        spinner.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                int selection = (int) spinner.getValue();
                comboBox.setModel(models.get(selection - 1));
            }
        });

        add(new JLabel("Selection:"));
        add(spinner);

        add(new JLabel("Combo:"));
        add(comboBox);
    }

    private static void createAndShowGui() {
        Foo2 mainPanel = new Foo2();

        JFrame frame = new JFrame("Foo2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}
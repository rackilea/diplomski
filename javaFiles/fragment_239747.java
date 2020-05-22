import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ComboBoxIntegerModel {

    private JComboBox comboBoxDouble;
    private JComboBox comboBoxInteger;
    private JComboBox comboBoxBoolean;
    private JComboBox comboBoxIcon;
    private Vector<Double> doubleVector = new Vector<Double>();
    private Vector<Integer> integerVector = new Vector<Integer>();
    private Vector<Boolean> booleanVector = new Vector<Boolean>();
    private Vector<Icon> iconVector = new Vector<Icon>();
    private Icon icon1 = ((UIManager.getIcon("OptionPane.errorIcon")));
    private Icon icon2 = (UIManager.getIcon("OptionPane.informationIcon"));
    private Icon icon3 = (UIManager.getIcon("OptionPane.warningIcon"));
    private Icon icon4 = (UIManager.getIcon("OptionPane.questionIcon"));

    public ComboBoxIntegerModel() {
        doubleVector.addElement(1.001);
        doubleVector.addElement(10.00);
        doubleVector.addElement(0.95);
        doubleVector.addElement(4.2);
        comboBoxDouble = new JComboBox(doubleVector);
        integerVector.addElement(1);
        integerVector.addElement(2);
        integerVector.addElement(3);
        integerVector.addElement(4);
        comboBoxInteger = new JComboBox(integerVector);
        booleanVector.add(Boolean.TRUE);
        booleanVector.add(Boolean.FALSE);
        comboBoxBoolean = new JComboBox(booleanVector);
        iconVector.addElement(icon1);
        iconVector.addElement(icon2);
        iconVector.addElement(icon3);
        iconVector.addElement(icon4);
        comboBoxIcon = new JComboBox(iconVector);
        JFrame frame = new JFrame("");
        frame.setLayout(new GridLayout(2,2,5,5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(comboBoxDouble);
        frame.add(comboBoxInteger);
        frame.add(comboBoxBoolean);
        frame.add(comboBoxIcon);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ComboBoxIntegerModel cBModel = new ComboBoxIntegerModel();
            }
        });
    }
}
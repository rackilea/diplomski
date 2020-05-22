import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.*;

public class ComboRendererTest {

    public ComboRendererTest() {
        JComboBox comboBox = new JComboBox();
        comboBox.setPrototypeDisplayValue("XXXXXXXXXXXXXXXX");
        comboBox.addItem(new Double(1));
        comboBox.addItem(new Double(2.25));
        comboBox.addItem(new Double(3.5));
        comboBox.setRenderer(new TwoDecimalRenderer(comboBox.getRenderer()));
        comboBox.setEditable(true);

        JComboBox comboBox1 = new JComboBox();
        comboBox1.setPrototypeDisplayValue("XXXXXXXXXXXXXXXX");
        comboBox1.addItem(new Double(1));
        comboBox1.addItem(new Double(2.25));
        comboBox1.addItem(new Double(3.5));
        comboBox1.setRenderer(new TwoDecimalRenderer(comboBox.getRenderer()));
        comboBox1.setEditable(true);

        JFrame frame = new JFrame();
        frame.add(comboBox, BorderLayout.NORTH);
        frame.add(comboBox1, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                ComboRendererTest comboRendererTest = new ComboRendererTest();
            }
        });
    }
}

class TwoDecimalRenderer extends DefaultListCellRenderer {

    private ListCellRenderer defaultRenderer;

    public TwoDecimalRenderer(ListCellRenderer defaultRenderer) {
        this.defaultRenderer = defaultRenderer;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        Component c = defaultRenderer.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus);
        if (c instanceof JLabel) {
            c.setBackground(Color.red);
        } else {
            c.setBackground(Color.red);
            c = super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
        }
        return c;
    }
}
import java.awt.*;
import javax.swing.*;

class MultiColumnCellRendererTest {

    public static void main(String[] args) {
        final String[] fruits = {
            "Apple",
            "Pear",
            "Banana",
            "Grapefruit"
        };

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JList fruitList1 = new JList(fruits);
                fruitList1.setCellRenderer(new MultiColumnCellRenderer());

                JList fruitList2 = new JList(fruits);
                fruitList2.setCellRenderer(new MultiColumnCellRenderer2());

                JPanel gui = new JPanel(new GridLayout(1,0,2,2));
                gui.add(fruitList1);
                gui.add(fruitList2);

                JOptionPane.showMessageDialog(null, gui);
            }
        });
    }
}

class MultiColumnCellRenderer extends JPanel implements
        ListCellRenderer {

    JLabel label;

    public MultiColumnCellRenderer() {
        setBackground(Color.RED);
        label = new JLabel();
        add(label);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        label.setText(value.toString());

        super.setEnabled(list.isEnabled());
        super.setFont(list.getFont());

        return this;
    }
}


class MultiColumnCellRenderer2 extends JPanel implements
        ListCellRenderer {

    JLabel label;

    public MultiColumnCellRenderer2() {
        setBackground(Color.GREEN);
        label = new JLabel();
        add(label);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        label.setText(value.toString());

        super.setEnabled(list.isEnabled());
        super.setFont(list.getFont());

        return this;
    }
}
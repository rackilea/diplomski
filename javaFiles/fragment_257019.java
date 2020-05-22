import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class SelectedComboBoxID {

    public SelectedComboBoxID() {
        JComboBox comboBox = new JComboBox();
        comboBox.addItem(new Item(1, "-"));
        comboBox.addItem(new Item(2, "Snowboarding"));
        comboBox.addItem(new Item(3, "Rowing"));
        comboBox.addItem(new Item(4, "Knitting"));
        comboBox.addItem(new Item(5, "Speed reading"));
        comboBox.addItem(new Item(6, "Pool"));
        comboBox.addItem(new Item(7, "None of the above"));
        comboBox.setMaximumRowCount(3);
        comboBox.setPrototypeDisplayValue(" None of the above ");
        comboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                Item item = (Item) comboBox.getSelectedItem();
                System.out.println(item.getId() + " : " + item.getDescription());
            }
        });
        //comboBox.setRenderer(new ItemRenderer());
        JFrame frame = new JFrame("MyComboEg");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(comboBox);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

   private class ItemRenderer extends BasicComboBoxRenderer {
        private static final long serialVersionUID = 1L;

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value != null) {
                Item item = (Item) value;
                setText(item.getDescription().toUpperCase());
            }
            if (index == -1) {
                Item item = (Item) value;
                setText("" + item.getId());
            }
            return this;
        }
    }

   private class Item {

        private int id;
        private String description;

        public Item(int id, String description) {
            this.id = id;
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return description;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                SelectedComboBoxID selectedComboBoxID = new SelectedComboBoxID();
            }
        });
    }
}
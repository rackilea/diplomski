import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingUtilities;

public class ComboBoxDemo {

    private List<Country> countries;
    private JComboBox cBox;

    public ComboBoxDemo() {
        countries = createCountryList();
        cBox = createComboBox(countries);

        JFrame frame = new JFrame();
        frame.add(cBox);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JComboBox createComboBox(List<Country> countries) {
        final JComboBox comboBox = new JComboBox(countries.toArray());
        comboBox.setRenderer(new ComboBoxRenderer());
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Country country = (Country) comboBox.getSelectedItem();
                    System.out.println(country.getIso());
                }
            }
        });
        return comboBox;
    }

    private class ComboBoxRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list,
                    value, index, isSelected, cellHasFocus);
            Country country = (Country) value;
            label.setText(country.getName());
            return label;
        }
    }

    private List<Country> createCountryList() {
        List<Country> list = new ArrayList<>();
        list.add(new Country("Afghanistan", "AF"));
        list.add(new Country("Åland Islands", "AX"));
        list.add(new Country("Albania", "AL"));
        return list;
    }

    public class Country {
        private String name;
        private String iso;

        public Country(String name, String iso) {
            this.name = name;
            this.iso = iso;
        }

        public String getName() {
            return name;
        }

        public String getIso() {
            return iso;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComboBoxDemo();
            }
        });

    }
}
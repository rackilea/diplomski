import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.function.Function;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 * @see http://stackoverflow.com/a/37222598/230513
 */
public class ComboRendererTest {

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
        DefaultComboBoxModel model = new DefaultComboBoxModel(new Person[]{
            new Person("Alpher", "alpher@example.com"),
            new Person("Bethe", "bethe@example.com"),
            new Person("Gammow", "gammow@example.com")});
        JComboBox<String> combo1 = new JComboBox<>(model);
        combo1.setRenderer(new PersonRenderer(Person::getName));
        JComboBox<String> combo2 = new JComboBox<>(model);
        combo2.setRenderer(new PersonRenderer(Person::getEmail));
        f.add(combo1);
        f.add(combo2);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static class PersonRenderer extends DefaultListCellRenderer {

        Function<Person, String> personAttribute;

        public PersonRenderer(Function<Person, String> personAttribute) {
            this.personAttribute = personAttribute;
        }

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object
            value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel l = (JLabel) super.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus);
            Person p = (Person) value;
            l.setText(personAttribute.apply(p));
            return l;
        }
    }

    private static class Person {

        private final String name;
        private final String email;

        public Person(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new ComboRendererTest()::display);
    }
}
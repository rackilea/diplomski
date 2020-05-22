import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.FilterList;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.ObservableElementList;
import ca.odell.glazedlists.TextFilterator;
import ca.odell.glazedlists.matchers.MatcherEditor;
import ca.odell.glazedlists.swing.EventSelectionModel;
import ca.odell.glazedlists.swing.EventTableModel;
import ca.odell.glazedlists.swing.TextComponentMatcherEditor;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GlazedListSelectionObservable {

    private JFrame frame;
    private JTable table;
    private JTextField txtInput;

    private EventList<Person> people;
    private EventSelectionModel<Person> selectionModel;

    public GlazedListSelectionObservable() {

        setupGui();
        setupGlazedLists();
        populatedList();
        frame.setVisible(true);
    }

    private void setupGui() {

        frame = new JFrame("GlazedLists Selection Example");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txtInput = new JTextField();
        table = new JTable();
        frame.getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);

        JButton updateTableButton = new JButton("Update selected row");

        updateTableButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!selectionModel.isSelectionEmpty()) {
                    EventList<Person> selectedPeople = selectionModel.getSelected();
                    for (Person person: selectedPeople) {
                        person.setFirstName("David");
                        person.setLastName("Baldacci");
                    }
                }
            }
        });

        frame.getContentPane().add(txtInput, BorderLayout.NORTH);
        frame.getContentPane().add(updateTableButton, BorderLayout.SOUTH);

    }

    private void populatedList() {
        people.add(new Person("John", "Grisham"));
        people.add(new Person("Patricia", "Cornwell"));
        people.add(new Person("Nicholas", "Sparks"));
        people.add(new Person("Andy", "Weir"));
        people.add(new Person("Elizabeth", "George"));        
    }

    private void setupGlazedLists() {
        people = new BasicEventList<Person>();
        MatcherEditor<Person> textMatcherEditor = new TextComponentMatcherEditor<Person>(txtInput, new PersonTextFilterator());

        ObservableElementList.Connector<Person> personConnector = GlazedLists.beanConnector(Person.class);
        EventList<Person> observedPeople = new ObservableElementList<Person>(people, personConnector);

        FilterList<Person> filteredPeople = new FilterList<Person>(observedPeople, textMatcherEditor);

        EventTableModel model = new EventTableModel(filteredPeople, GlazedLists.tableFormat(new String[]{"firstName", "lastName"} , new String[]{"First Name", "Last Name"}));

        selectionModel = new EventSelectionModel<Person>(filteredPeople);

        table.setModel(model);
        table.setSelectionModel(selectionModel);
    }

    class PersonTextFilterator implements TextFilterator<Person> {

        @Override
        public void getFilterStrings(List<String> list, Person person) {
            list.add(person.getFirstName());
            list.add(person.getLastName());
        }

    }

    public class Person {

        private String firstName;
        private String lastName;

        private final PropertyChangeSupport support = new PropertyChangeSupport(this);

        public Person() {
        }

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setFirstName(String firstName) {
            final String oldFirstName = this.firstName;
            this.firstName = firstName;
            support.firePropertyChange("firstName", oldFirstName, firstName);
        }

        public void setLastName(String lastName) {
            final String oldLastName = this.lastName;
            this.lastName = lastName;
            support.firePropertyChange("lastName", oldLastName, lastName);
        }

        public void addPropertyChangeListener(PropertyChangeListener l) {
            support.addPropertyChangeListener(l);
        }

        public void removePropertyChangeListener(PropertyChangeListener l) {
            support.removePropertyChangeListener(l);
        }

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
              new GlazedListSelectionObservable();
            }
        });
    }

}
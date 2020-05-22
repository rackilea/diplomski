public class PersonTable extends JTable {

    private PersonTableModel tableModel;

    public PersonTable(List<Person> listPerson) {
        tableModel = new PersonTableModel(listPerson);
        setModel(tableModel);
        setDefaultRenderer(Person.class, new PersonCellRenderer());
        setDefaultEditor(Person.class, new PersonCellEditor(listPerson));
    }

    public List<Person> getAllPersons() {
        List<Person> set = new ArrayList<Person>();

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            set.add(tableModel.getPerson(i));
        }

        return set;
    }

}
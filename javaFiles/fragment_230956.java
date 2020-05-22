public class PeopleTableModel extends AbstractTableModel {

    private List<Person> people;

    public PeopleTableModel() {
        people = new ArrayList<>(20);
    }

    public void addPerson(Person person) {
        people.add(person);
        fireTableRowsInserted(people.size() - 1, people.size() - 1);
    }

    public Person getPersonAt(int row) {
        return people.get(row);
    }

    public List<Person> getChangedPeople() {
        List<Person> changed = new ArrayList<>(people.size());

        for (Person p : people) {
            if (p.hasChanged()) {
                changed.add(p);
            }
        }

        return changed;    
    }

    @Override
    public int getRowCount() {
        return people.size();
    }

    @Override
    public String getColumnName(int column) {
        String name = null;
        switch (column) {
            case 0:
                name = "First name";
                break;
            case 1:
                name = "First name";
                break;
        }
        return name;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person p = people.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = p.getFirstName();
                break;
            case 1:
                value = p.getLastName();
                break;
        }
        return value;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue instanceof String) {
            Person p = people.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    p.setFirstName(aValue.toString());
                    break;
                case 1:
                    p.setLastName(aValue.toString());
                    break;
            }
            fireTableRowsUpdated(rowIndex, rowIndex);
        }
    }
}
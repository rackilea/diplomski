public class PersonTableModel extends AbstractTableModel {

    private List<Person> persons;

    public int getRowCount() {
        return persons.size();
    }

    public int getColumnCount() {
        return 3;
    }

    public Object getValueAt(int row, int col) {
        if (col == 0) {
            return row + 1;
        }
        else if (col == 1) {
            return persons.get(row).getFirstName();
        }
        else {
            return persons.get(row).getLastName();
        }
    }
    ...
}
public class LibraryTableModel extends AbstractTableModel {

    private String[] columnNames = {"Titel", "Autor", "Status", "Genre", "Verlag", "Seitenzahl", "ISBN", "Sprache", "Bewertung"};
    private Object[][] data = {};

    private Library lib;

    public LibraryTableModel(Library l) {
        lib = l;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return lib.getList().size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Book book = lib.getList().get(row);
        Object value = null;
        switch (col) {
            case 0:
                value = ...;
                break;
            case 1:
                value = ...;
                break;
            case 2:
                value = ...;
                break;
            case 3:
                value = ...;
                break;
            case 4:
                value = ...;
                break;
            case 5:
                value = ...;
                break;
            case 6:
                value = ...;
                break;
            case 7:
                value = ...;
                break;
            case 8:
                value = ...;
                break;
        }
        return value;
//When I try to remove a Book, the ArrayOutOfBounds Exception comes from here
    }

    public Class getColumnClass(int c) {
        // Don't do this, know the actualy value and return it
        // Otherwise you could end up with a NullPointerException
        return getValueAt(0, c).getClass();
    }

    public void setValueAt(Object value, int row, int col) {
        // Use a simular technquie to getValueAt to extract the Book for the give
        // row and update the Book's attributes
        fireTableCellUpdated(row, col);
    }

    public void removeRow(int row) {
        lib.remove(row);
        fireTableRowsDeleted(row, row);
    }

}
public class MyDefaultTableModel extends DefaultTableModel {
    private Class[] columnClasses;
    public Class[] getColumnClasses() {
        return columnClasses;
    }
    public void setColumnClasses(Class[] columnClasses) {
        this.columnClasses = columnClasses;
    }
    @Override
    public Class getColumnClass(int columnIndex) {
        return columnClasses[columnIndex];
    }
}
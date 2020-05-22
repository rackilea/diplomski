class MyTableModel implements AbstractTableModel {
    private List<MyDomain> data = ...
    ...

    public void clear() {
        data.clear();               // clear container
        fireTableDataChanged();     // notify listeners 
    }

    ...
}
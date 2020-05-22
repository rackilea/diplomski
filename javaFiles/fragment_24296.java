public class MyTableModel extends AbstractTableModle {

private MyDataClass myData; // holds the cell data

private static final String[] colNames = {"bla", "blabla", "hola", "hej", "egle", "begle", "eciepecie"};

public MyTableModel(MyDataClass val) {
    myData = val;
    myData.data = new Object[7][7];
}

@Override
public int getColumnCount() {
    return myData.data.length;
}

@Override
public int getRowCount() {
    return myData.data[0].length;
}

@Override
public Object getValueAt(int arg0, int arg1) {
    return myData.data[arg0][arg1];
}

@Override
public String getColumnName(int columnIndex) {
    return colNames[columnIndex];
}

@Override
public boolean isCellEditable(int rowIndex, int columnIndex) {
    if (rowIndex == columnIndex)
        return false;
    else return true;
}

@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        myData.data[columnIndex][rowIndex] = aValue;
    }

}
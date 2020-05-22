@Override
public Class<?> getColumnClass(int col) {

    Class retVal = Object.class;

    if(getRowCount() > 0)
        retVal =  getValueAt(0, col).getClass();

    return retVal;
}
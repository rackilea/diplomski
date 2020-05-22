@Override
public void setValueAt(Object aValue, int row, int column) {
    if (DEF.get(column).getValueSetterFunction() != null) {
        DEF.get(column).getObjectValueSetterFunction().accept(getObjectAt(row), aValue);
    }
}
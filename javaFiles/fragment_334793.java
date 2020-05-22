public Class<? extends Object> getColumnClass(int c) {
    Object object = getValueAt(0, c);
    if(object == null) {
        return Object.class;
    if(getValueAt(0, c) instanceof IColorable) {
        return ICarPart.class;
    } else {
        return getValueAt(0, c).getClass();
    }
}
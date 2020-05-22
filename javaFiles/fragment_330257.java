// This list model has about 2^16 elements.  Enjoy scrolling.

ListModel bigData = new AbstractListModel() {
    public int getSize() { return Short.MAX_VALUE; }
    public Object getElementAt(int index) { return "Index " + index; }
};
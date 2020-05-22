ListModel bigData = new AbstractListModel() {
    ArrayList customers;
    public int getSize() { return customers.size() }
    public Object getElementAt(int index) { return customers.get(index); }
};

JList bigDataList = new JList(bigData);
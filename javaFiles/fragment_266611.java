ListModel source = new DefaultListModel(); // use a model of your choice here;
    FilteredListModel filteredListModel = new FilteredListModel(source);
    JList list = new JList(filteredListModel);
    filteredListModel.setFilter(new FilteredListModel.Filter() {
        public boolean accept(Object element) {
            return false; // put your filtering logic here.
        }
    });
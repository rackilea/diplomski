private DefaultListModel model = new DefaultListModel;

public Constructor () {
    JList playlist = new JList(model);
    panelTop.add(playlist);
    ...
}

public void addItem (String item) {
    model.add(0, item);
}

public void removeItem (String item) {
    model.remove(model.indexOf(item));
}

public void clearItems () {
    model.clear();
}
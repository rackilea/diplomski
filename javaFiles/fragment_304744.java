@Override
public void valueChanged(ListSelectionEvent e) {
    ListSelectionModel selectedModel = (ListSelectionModel) e.getSource();
    for (ListSelectionModel model : models) {
        if (model != selectedModel) {
            model.removeListSelectionListener(this);
            model.clearSelection();
            model.addListSelectionListener(this);
        }
    }
}
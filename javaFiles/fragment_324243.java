public static <E> JList<E> list(ListModel<E> listModel, ListCellRenderer<? super E> cellRenderer) {
    JList<E> list = new JList<>();
    if (cellRenderer != null) {
        list.setCellRenderer(cellRenderer);
    }
    else {
        list.setCellRenderer(new CustomeListCellRenderer());
    }
    list.setModel(listModel);
    if (listModel != null) {
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    return list;
}
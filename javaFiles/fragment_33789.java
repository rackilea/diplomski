public void toggleSelection(Boolean select) {
    List data = new ArrayList();

    for (int idx = 0; idx < 5; idx++){
        Object record[] = new Object[] {select, "test", "test"};
        data.add(record);
    }

    TableModel model = new TableModel(data);
    customerTable.setModel(model);
}
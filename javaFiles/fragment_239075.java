public static TableModel toTableModel(Map<?, ?> map, List<?> list) {
    DefaultTableModel model = new DefaultTableModel(new Object[] { "Key", "Value" }, 0);
    for (Map.Entry<?, ?> entry : map.entrySet()) {

        for (int a = word.size()/2000; model.getColumnCount() - 2 <= a;) {
            model.addColumn(new Object[] { "partial" });
        }

        // Create the object that holds all the columns
        Object[] temp = new Object[2+list.size()];
        temp[0] = entry.getKey();
        temp[1] = entry.getValue();

        int index = 2;
        for (Object o : list) {

            Map<?, ?> m = (Map<?, ?>) o;
            // Get the chunck-specific count with the correct key (the name)
            temp[index] = m.get(temp[0]);
            index++;
        }
        model.addRow(temp);
    }
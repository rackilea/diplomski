public void fillTable(){
       List<String> columns = new ArrayList<String>();
       List<String[]> values = new ArrayList<String[]>();
        columns.add("col1");
        columns.add("col2");
        columns.add("col3");
        for (int i = 0; i < 100; i++) {
            values.add(new String[] {"val"+i+" col1","val"+i+" col2","val"+i+" col3"});
        }
        TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
        tableName.setModel(tableModel);
    }
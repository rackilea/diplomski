String basePath = "C:\\excel file path";
     DataTable table = new DataTable();
     table.setHeaderless();
     table.ImportSheet(basePath+"myTestingFile.xlsx");
     System.out.println(Arrays.toString(table.getHeaderValues().toArray()));

     for(int i = 1 ; i < table.getRowCount();i++){
        table.setRowIndex(i);
       System.out.println(table.getValueAt(0));
    }
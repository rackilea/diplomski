static void populateTable(ArrayList<String> list){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("title", list.toArray());
        table.setModel(dtm);
    }
    }
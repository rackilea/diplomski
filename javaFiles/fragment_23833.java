DefaultTableModel dtm123;

@Override
protected void process(List<Integer> chunks) {
    if(chunks!=null) {
        ListIterator<Integer> li = chunks.listIterator();
        int next;

        while(li.hasNext()) {
            next = li.next();

            if(next==-1) {
                //Set up columns/column titles here
                myTable.setModel(new DefaultTableModel(
                    new Object[][] {},
                    columnHeaderArray
                ));
                dtm123 = (DefaultTableModel) myTable.getModel();
            } else {
                //Add new rows here
                dtm123.addRow(myDataList.get(next).getRowArray());
            }
        }
    }
}
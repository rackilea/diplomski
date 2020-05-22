String[] titles = {"System Code","Domain Name","Organizational Unit","Organization Name"};
    TableColumn[] columns = new TableColumn[titles.length];
    for(int i=0; i<titles.length; i++)
    {
        TableColumn column = new TableColumn(table, SWT.LEFT, i);
        column.setText(titles[i]);
        column.setWidth(150);
        column.setMoveable(true);
        column.setResizable(true);
        columns[i] = column;
    }
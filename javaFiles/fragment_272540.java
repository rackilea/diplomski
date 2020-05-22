private void setTableItemList() {
    topPanel = new JPanel();
    topPanel.setLayout(new BorderLayout());
    getContentPane().add(topPanel); // <-- topPanel added for first time

    // Create columns names
    String columnNames[] = {"Column 1", "Column 2", "Column 3"};    
    // Create some data
    String dataValues[][] = {
        {"12", "234", "67"},
        {"-123", "43", "853"},
        {"93", "89.2", "109"},
        {"279", "9033", "3092"}
    };

    // Create a new table instance
    table = new JTable(dataValues, columnNames);    
    // Add the table to a scrolling pane
    ScrollPane = new JScrollPane(table);
    topPanel.add(ScrollPane, BorderLayout.CENTER);
    jPanel3.add(topPanel); // <-- topPanel added second time to another container
}
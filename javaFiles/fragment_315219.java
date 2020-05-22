// load the data from database into a vector
    ResultSet resultSet = stmt.executeQuery();
    Vector data = new Vector();
    while (resultSet.next()) {
        Vector row = new Vector();
        row.add(resultSet.getString(1));
        row.add(resultSet.getInt(2));
        data.add(row);
    }

    // initialize the column names
    Vector columnNames = new Vector();
    columnNames.add("Name");
    columnNames.add("Num");

    // create the jtable with the data and the column names
    JTable jTable = new JTable(data, columnNames);

    JFrame jFrame = new JFrame();
    jFrame.setVisible(true);
    jFrame.add(new JScrollPane(jTable));
    jFrame.pack();
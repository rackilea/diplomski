try {
        Class.forName("com.mysql.jdbc.Driver");
        conn3 = DriverManager.getConnection("jdbc:mysql://localhost/test1?user=me&password=123456");
        stmt3 = conn3.createStatement();
        ResultSet rowCounter = stmt3.executeQuery("SELECT COUNT(*) FROM teams");
        rowCounter.next();
        int numRows = rowCounter.getInt(1);
        stmt3.close();            
        Object[][] data = new Object[numRows][5];
        stmt3 = conn3.createStatement();
        rs3 = stmt3.executeQuery("SELECT * FROM teams");
        int row = 0;
        while (rs3.next()) {
            data[row][0] = rs3.getString(1);
            data[row][1] = rs3.getString(2);
            data[row][2] = rs3.getString(3);
            data[row][3] = rs3.getString(4);
            data[row][4] = rs3.getString(5);
            row++;
        }
        String[] columnNames = {"id","Name","Players","Point","Position" };
        table = new JTable(data,columnNames);
        table.setCellSelectionEnabled(true);
        table.setColumnSelectionAllowed(true);
        table.setFillsViewportHeight(true);
        table.setSurrendersFocusOnKeystroke(true);
        table.setBounds(10, 321, 297, 143);
        frame.getContentPane().add(table);
        rs3.close();
        stmt3.close();
        conn3.close();
}
catch (SQLException se) {
    //handle this
}
catch (ClassNotFoundException ex) {
       System.out.println("Error: unable to load driver class!");
}
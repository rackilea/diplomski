stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM table1");

TableModel normalTableModel = DBUtils.resultSetToTableModel(rs);
TableModel transposedTableModel = new TransposedTableModel(normalTableModel);

JTable swingTable = new JTable (transposedTableModel);
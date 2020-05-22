DefaultTableModel model = new DefaultTableModel();

Class.forName("com.mysql.jdbc.Driver");
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/efefe?autoReconnect=true&useSSL=false","root","");

ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM customer");

tableModel.addColumn("gender");

int row = 0;

while (rs.next()) {
    tableModel.addRow(new Object[] {});
    tableModel.setValueAt(rs.getString("gender"), row, 0);
    row++;
}

table.setModel(tableModel);
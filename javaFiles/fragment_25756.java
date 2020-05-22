public static void main(String[] args) throws Exception {
    // The Connection is obtained

    ResultSet rs = stmt.executeQuery("select * from product_info");

    // It creates and displays the table
    JTable table = new JTable(buildTableModel(rs));

    // Closes the Connection

    JOptionPane.showMessageDialog(null, new JScrollPane(table));

}
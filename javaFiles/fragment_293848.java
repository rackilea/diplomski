// create a table model with the appropriate column headers
// and with 0 rows (to start with)
String[] columnNames = {"Title", "Season", "Episode"};
DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

while (rs.next()) {
    String title = rs.getString("Title");
    String season = rs.getString("Season");
    String episode = rs.getString("Episode");

    // create a single array of one row's worth of data
    String[] data = { title, season, episode } ;

    // and add this row of data into the table model
    tableModel.addRow(data);
}

jt.setModel(tableModel); // place model into JTable
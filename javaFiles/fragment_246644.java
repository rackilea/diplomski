//You don't need this line, remove it
//int columnCount = rs.getMetaData().getColumnCount();
while(rs.next()) {
    //create a new instance of MonitorAlertInstance per ResultSet row
    MonitorAlertInstance monitor = new MonitorAlertInstance();
    //set the fields from the ResultSet in your MonitorAlertInstance fields
    //since I don't know the fields of this class, I would use field1 and field2 as examples
    monitor.setField1(rs.getInt(1));
    monitor.setField2(rs.getString(2));
    //and on...
    systemHealthAlertList.add(monitor);
}
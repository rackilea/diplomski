String sql = "update RoomStatusTable2 set Details=?, Status=?, BillPerDay=?, "
       + "ClientName=?, ClientAddress=?, ContactNo=?, EntryDate=?, "
       + "LeavingDate=? "
       + "where RoomNo = ?";
try (PreparedStateent pstatement = connection.prepareStatement(sql)) {
    pstatement.setString(1, value2);
    pstatement.setString(2, value3);
    pstatement.setString(3, value4);
    pstatement.setString(4, value5);
    pstatement.setString(5, value6);
    pstatement.setString(6, value7);
    pstatement.setString(7, value8);
    pstatement.setString(8, value9);
    pstatement.setInt(9, Integer.parseInt(value1));
    pstatement.executeUpdate();
} // Closes pstatement.
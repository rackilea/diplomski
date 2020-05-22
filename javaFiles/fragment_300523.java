while(rs.next()){
    Object[] rowData = {
         rs.getString("empId"),
         rs.getString("name")
    };
    dtm.addRow(rowData);
}
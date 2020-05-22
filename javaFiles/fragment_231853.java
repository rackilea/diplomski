String colNames = " ";
String colValues = " ";
for (int i=0; i<cols.size(); i++) {
    if(i!=0){
       colNames += ", ";
       colValues += ", ";
    }
    colNames += cols.get(i);
    colValues += "?";              
}       

try (PreparedStatement pst = connHandler.conn.prepareStatement("INSERT INTO `" + tableName + "` (" + colNames + ") VALUES (" + colValues + ") ");){

    for (int i = 0; i < values.size(); i++) {
        pst.setString(i+1,values.get(i));       
    }

    pst.executeUpdate();
}
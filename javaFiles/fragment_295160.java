ResultSet rs = stmt.executeQuery( "SELECT distinct "+jTextField.getText()+
    " as call from tablename");
List<String> results = new ArrayList<String>();
while(rs.next()) {
    results.add(rs.getString(1));
}
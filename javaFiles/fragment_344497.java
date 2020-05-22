String bs = search.getText();
String SQL = "select * from BENEFICIARIES where localgovernment = '" +bs+"'";
rs = stmt.executeQuery(SQL);
List<String> kjh = new ArrayList<String>();
while(rs.next()){
    int id = rs.getInt("bid");
    String name = rs.getString("name");
    String gender = rs.getString("gender");
    String Phone = rs.getString("phone");
    String mail = rs.getString("email");
    String lga = rs.getString("localgovernment"); 
    String address = rs.getString("address");
    String etype = rs.getString("typeofempowerment");
    String benefits = rs.getString("listofbenefits");
    mega = id + " "+ name +" "+gender+" "+Phone+" "+mail+" "+lga+" "+address+" "+etype+" "+benefits;
    kjh.add(mega);
}
String jhg="";
for(String s:kjh)
    jhg+=s+"\n";
result.setText(jhg);
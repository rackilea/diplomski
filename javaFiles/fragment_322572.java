int id=0;
String sql = "Select ID from Temp";
ResultSet rs = statement.executeQuery(sql);

while(rs.next(){
   id = rs.getInt(1);
  /*   pass your update query here and use like this it should work for you
    update m_auth_info  set name  = '"+name+"',
    addr  = '"+addr+"',  email = '"+email+"', 
    affiliation = '"+affil+"', status = '"+1+"'  where a_id = '"+id+"'";*/
}
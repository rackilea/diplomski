public class RetriveRecords {

 public ArrayList listMethod(){
  ArrayList list = new ArrayList();
 try {
        //Standard JDBC Code
    Statement stmt = con.createStatement();
    String query = "select * from emp"; // Your own Query

    ResultSet rs = stmt.executeQuery(query);
    while(rs.next()) {

            Employee e = new Employee();
            e.setEno(rs.getInt(eno);
            e.setEName(rs.getString("ename");
            list.add(e);
}
   con.close();      
}
catch(Exception e){
    e.printStackTrace();
}
  return list;
}
}
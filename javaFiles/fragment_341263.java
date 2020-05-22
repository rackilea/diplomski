<%

String eid = request.getParameter("eid");
String first_name = request.getParameter("first_name");
if(eid != null && first_name != null){ 
    Connection conn = null; 
    Statement stmt = null; 
    ResultSet result = null; 
    Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
    try{
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Password"); 
        PreparedStatement ps = null;
        String query = "insert into employee(eid,ename) values(?,?)";       
        ps = conn.prepareStatement(query);
        ps.setString(1,eid);
        ps.setString(2,first_name);
        ps.executeUpdate();
    }catch(SQLException sqle){
        //log sql exception     
    } finally {
        if(conn != null){
            try{
                conn.close();
            }catch(SQLException sqle){
                //log exception
            }
    }
}
%>
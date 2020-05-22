<%
String user=request.getParameter("un");
String pass=request.getParameter("pw");    
if (user != null && pass != null) {
    Connection c = connect();
    PreparedStatement pst=c.prepareStatement("insert into userpass (id,password) values (?,?)");
    pst.setString(1, user);
    pst.setString(2, pass);

    int val=pst.executeUpdate();

    if(val>0)
        System.out.println("Inserted record");
}
%>
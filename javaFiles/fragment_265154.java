@POST
@Path("insertion")
@Produces(MediaType.TEXT_HTML)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public String register(@FormParam("passhash") String passhash, @FormParam("email") String email,@FormParam("$pswdhash") String pwd, @FormParam("phno") String phno) {
    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/test", "app", "app");
        PreparedStatement pst = con.prepareStatement("insert  into  MMX_REGISTRATION(name,email,pswd,phno) values(?,?,?,?)");
        pst.setString(1, passhash);
        pst.setString(2, email);
        pst.setString(3, pwd);
        pst.setString(4, phno);
        int result = pst.executeUpdate();
        System.out.println(result);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "success";
    //return "listform.html";
}
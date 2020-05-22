@Context private HttpServletRequest request; 
@GET
@Path("session")
@Produces(MediaType.TEXT_HTML)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public String session(@QueryParam("lname") String name1) {
    String response2 = null;
   //String name11 = "praveen";

     //String a[] = null;

    try {

        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/test", "app", "app");
        //PreparedStatement pst = con.prepareStatement("insert  into  restdb_insertion(id,company) values(?,?)");
        //String str1="select * from restdb_insertion where registration=?";
        PreparedStatement pst = con.prepareStatement("select * from MMX_REGISTRATION where name='"+name1+"'");
        System.out.println("select * from MMX_REGISTRATION where name='"+name1+"'");

        ResultSet rs = pst.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int cols = rsmd.getColumnCount();


        while (rs.next()) {
            if(!"null".equals(rs.getString(1))){
                 request.getSession(true);
                 HttpSession session = request.getSession();    
                 session.setAttribute("name","value");
                 session.setAttribute("UserName", rs.getString(2));
                 String username = (String)session.getAttribute("UserName");
                 System.out.println(username);
               //  System.out.println(name);
                 //request.getSession(false);
                 //request.getSession().invalidate();
                 //String user = (String)session.getAttribute("UserName");
                 //System.out.println(user);
                return "success"+" "+username;
            }
        }

       //response = name1;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "fail";

    //"<rss version='2.0'><channel><id>" + id + "</id><cmp>" +response.toArray()[0] + "</cmp></channel></rss>"
}
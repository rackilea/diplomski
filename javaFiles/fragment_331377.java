<body>
<%
String id = request.getParameter("id");
System.out.println("id is"+id);
try{
    DBConnect db =new DBConnect();
    Connection con = db.getCon();
    String sql ="delete from marketing_database.tax_info where id = '"+id+"'";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.executeUpdate();
    con.close();
    ps.close();

        }
        catch(SQLException ex){
    ex.printStackTrace();
        }


response.sendRedirect("taxInfo.jsp");
%>

</body>
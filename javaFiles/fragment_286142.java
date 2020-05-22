public void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
    PrintWriter pw = response.getWriter();
    doSQL(pw);
}

public static void doSQL(PrintWriter pw) {
    try {
        String url = "jdbc:msql://...";
        Connection conn = DriverManager.getConnection(url,"user","password");
        Statement stmt = conn.createStatement();
        ResultSet rs;

        rs = stmt.executeQuery("SELECT Lname FROM Customers WHERE Snum = 2001");
        pw.println("<html><table>");
        while (rs.next()) {
            // you only select one field, but you can easily adapt
            // this code to have more fields (i.e. table columns)
            String lastName = rs.getString("Lname");
            pw.println("<tr><td>" + lastname + "</td></tr>");
        }
        pw.println("</table></html>");
        conn.close();
    } catch (Exception e) {

        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());
    }
}
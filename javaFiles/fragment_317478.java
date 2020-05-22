PreparedStatement stmt = null;
try {
    stmt = new PreparedStatement("select * from regis where emp_id=? and password=?");
    stmt.setString(1, employee);
    stmt.setString(2, password);

    ResultSet rs = stmt.executeQuery();
    if(rs.next()) {
        System.out.println("2> Employee Id : "+employee+" && Password : "+password);
        System.out.println("3> This employee "+employee+" exsists in the database and                        
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("<head>");
        out.print("<title>Policy Page</title>");
        out.print("<link rel='icon' href='../images/favicon.png'/>");
        out.print("</head>");
        String status = (String) req.getAttribute(ATTRIBUTE_STATUS);
        if (status != null)
        {
          out.print("Status :"+status);
        }
        List<String> devices = Datastore.getDevices();
        if (devices.isEmpty())
        {
          out.print("<h2>No  devices registered!</h2>");
        } 
        else
        {

         out.print("<h2>" + devices.size() + " device(s) registered!</h2>");
         out.print("<form name='form' method='POST' action='sendAll'>");
         out.print("<input type='text' name='policy'>");
         resp.setStatus(HttpServletResponse.SC_OK);
         out.print("<input type='submit' value='Apply Policy'>");
         out.print("</form>");
//       System.out.println(HTTP_STATUS);
         System.out.println(HttpServletResponse.SC_OK);
         getServletContext().getRequestDispatcher("/home").forward(req, resp);

        }
        out.print("</body></html>");
        resp.setStatus(HttpServletResponse.SC_OK);

    }

    else {
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        System.out.println(HttpServletResponse.SC_BAD_REQUEST);
        System.out.println("4> This employee "+employee+" does not exsist in the database");            
    }
}
catch(Exception e) {
    e.printStackTrace();
}
finally {
    try {
        stmt.close();
    } catch(Exception x) {}
}
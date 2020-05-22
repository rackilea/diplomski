String[] id         = request.getParameterValues("assignchkbox");
        String userId       = request.getParameter("UserID");
        String arm[]          = request.getParameterValues("Arm");
        String armNumber    = request.getParameter("ArmNumber");
        String leg          = request.getParameter("Leg");
        String legNumber    = request.getParameter("LegNumber");

        out.println("<tr>");
        out.println("<td style='width: 10%'>");
        out.println(userId);
        out.println("</td>");
        out.println("<td style='width: 10%'>");
        out.println(arm);
        out.println("</td>");
        out.println("<td style='width: 10%'>");
        out.println(armNumber);
        out.println("</td>");
        out.println("<td style='width: 10%'>");
        out.println(leg);
        out.println("</td>");
        out.println("<td style='width: 10%'>");
        out.println(legNumber);
        out.println("</td>");
        out.println("</tr>");


        int count           =0;
        Connection conn     = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connURL = "jdbc:mysql://99/hi?user=00&password=000";
            conn = DriverManager.getConnection(connURL);
            String sql="Insert into assign(UserID, Arm ,ArmNumber,Leg,LegNumber) Values(?,?,?,?,?)";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            for(String chk:arm){
                  pstmt.setString (1,userId);
                  pstmt.setString (2,chk);
                  pstmt.setString (3,armNumber);
                  pstmt.setString (4,leg);
                  pstmt.setString (5,legNumber);
                  preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }catch(SQLException e){
         e.printStackTrace();
        }
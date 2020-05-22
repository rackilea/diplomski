PreparedStatement ps = con.prepareStatement("select * from activities where type=? AND city=? AND location=? AND date=?");

ps.setString(1, request.getParameter("type"));
ps.setString(2, request.getParameter("city"));
ps.setString(3, request.getParameter("location"));
ps.setString(4, request.getParameter("date"));

rs = ps.executeQuery();
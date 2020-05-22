String sql = "select * from students where id="+ request.getParameter("st_id");
ResultSet rs= stmt.executeQuery(sql);

if(rs.next()){
    if (rs.wasNull()) {
        request.getRequestDispatcher("/login_fail.jsp").forward(request, response);
    }else{
        request.setAttribute("name", rs.getString("name"));
        request.getRequestDispatcher("/login_action.jsp").forward(request, response);
    }
}
try {
  ...
  al.add(rs.getDouble("user_name")); <-- Exception thrown
  al.add(rs.getDouble("user_address"));
      ...
   String url = "/admin/orders.jsp";
  RequestDispatcher dispatcher =
   getServletContext().getRequestDispatcher(url);                        
  dispatcher.forward(request, response);
} catch (SQLException e) {  <-- Exception catch
  e.printStackTrace();
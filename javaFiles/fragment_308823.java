private void listTrans(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException {
  int id = Integer.parseInt(request.getParameter("id"));
  List<Credits> creditlist = OrganizerDao.getAllCredits(id);
  request.setAttribute("creditlist", creditlist);
  response.sendRedirect("resultpage.jsp");  
}
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String actionName = req.getParameter("action");
    String objectType = req.getParameter("object");
    String selectionList = req.getParameter("selection");
    String tenantsList = req.getParameter("tenants");

    PrintWriter out = resp.getWriter();
    out.print("<div>" + actionName + " " + objectType + " " + selectionList + " " + tenantsList + "</div>");

}
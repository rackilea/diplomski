try {
    CakeDAO dao = new CakeDAO();
    String strID = request.getParameter("id");
    int id = Integer.parseInt(strID);
    PrintWriter out = response.getWriter();
    out.println("Cake: " + dao.getCakeById(id)); // Hereafter an exception would err.
    // NEVER forward: ... .forward(request, response);
} catch (Exception ex) {
    request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
}
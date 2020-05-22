try {
    CakeDAO dao = new CakeDAO();
    String strID = request.getParameter("id");
    int id = Integer.parseInt(strID);
    request.setAttribute("cake", dao.getCakeById(id));
    request.getRequestDispatcher("/WEB-INF/detail.jsp").forward(request, response);
} catch (Exception ex) {
    request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
}
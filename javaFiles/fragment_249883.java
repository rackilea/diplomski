@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Long editId = Long.valueOf(request.getParameter("editId")); // Handle nullcheck yourself.
    Data editData = dataService.find(editId);
    request.setAttribute("editData", editData); // For the edit form.
    List<Data> allData = dataService.list();
    request.setAttribute("allData", allData); // For the table/list of all data.
    request.getRequestDispatcher("/index.jsp").forward(request, response);
}
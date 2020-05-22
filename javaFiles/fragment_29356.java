protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String type = request.getParameter("type"); // Returns "country" or "state".
    String value = request.getParameter("value"); // Value of selected country or state.
    Map<String, String> options = optionDAO.find(type, id); // Do your thing to obtain them from DB. Map key is option value and map value is option label.
    String json = new Gson().toJson(options); // Convert Java object to JSON string.

    response.setContentType("application/json"); // Inform client that you're returning JSON.
    response.setCharacterEncoding("UTF-8"); // Important if you want world domination.
    response.getWriter().write(json); // Write JSON string to response.
}
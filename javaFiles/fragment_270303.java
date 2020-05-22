@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Just a basic example. In real, just retrieve data from DB.
    List<String> list = new ArrayList<String>();
    list.add("item1");
    list.add("item2");
    list.add("item3");
    String json = new Gson().toJson(list);

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    List<String> animals = new ArrayList<String>();
    animals.add("Sylvester");
    animals.add("Goofy");
    animals.add("Mickey");
    request.setAttribute("animals", animals);
    request.getRequestDispatcher("/WEB-INF/animals.jsp").forward(request, response);
}
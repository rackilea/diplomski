protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Person person = personDAO.find(request.getParameter("personId"));
    response.setContentType("text/xml");
    response.setCharacterEncoding("UTF-8");
    new XStream().toXML(person, response.getWriter());
}
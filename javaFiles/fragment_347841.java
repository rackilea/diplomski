public void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {
    String author = checkNull(req.getParameter("author"));
    String service = checkNull(req.getParameter("service"));
    Dao.INSTANCE.add(author, service);
    List shortlys = new ArrayList();
    shortlys = Dao.INSTANCE.getShortlys("default");
    System.out.println("Shortlys count is: " + shortlys.size());
    resp.sendRedirect("/myApplication.jsp");
}
public void doPost(HttpServletRequest req, HttpServletResponse resp)throws IOException {
       String name=req.getParameter("name");
       response.setContentType("text/plain");
       response.setCharacterEncoding("UTF-8");
       response.getWriter().write(name);

}
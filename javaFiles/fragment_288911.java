public void doPost (HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException    
{
    HttpSession session = req.getSession();
    session.setAttribute("Variable1", request.getParameter("input1"));
    //and so on..
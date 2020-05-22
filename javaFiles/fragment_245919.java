@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
        throws ServletException, IOException {
    ServletContext context = getServletContext();
    synchronized (context) { // Or choose something else...
        Integer count = (Integer) context.getAttribute("ctr");
        context.setAttribute("ctr", count + 1);
    }
}
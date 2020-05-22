protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if(action != null && action.equals("register")) {
       RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Views/System/registration.jsp");
       view.forward(request, response);
    } else {
      PrintWriter out = response.getWriter();
      out.print("Served at: "+request.getContextPath());    
      RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Views/System/index.jsp");
      view.forward(request, response);
    }
}
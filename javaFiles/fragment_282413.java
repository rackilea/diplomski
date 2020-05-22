protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

  String action = request.getParameter("action");

  switch(action){

  case "action1":
    doAction1(request, response); //Method with the logic of your Servlet1 class
    break;
  case "action2":
    doAction2(request, response);
    break;
  default:
    throw new ServletException("Invalid action parameter");

  }

}
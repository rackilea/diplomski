public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      // Set response content type
      response.setContentType("text/html");

      // Call commands
      PrintWriter out = response.getWriter();
      ExampleMethod();
      out.println("<h1>" + Method Executed + "</h1>");
   }
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
out.println("your_response");

RequestDispatcher dispatcher = request.getRequestDispatcher("/yourPage.html");
dispatcher.forward(request, response);
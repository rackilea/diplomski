protected void doGet(HttpServletRequest request, HttpServletResponse response throws          
  ServletException, IOException 
{  
   RequestDispatcher rd = request.getRequestDispatcher("Signup.jsp");  
   rd.forward(request, response);  
}
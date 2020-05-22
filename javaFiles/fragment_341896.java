public class LoginServlet extends HttpServlet {

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
           PrintWriter out = response.getWriter();
           try {
           String un,pw;
           un=request.getParameter("username");
           pw=request.getParameter("password");
           System.out.println("username :"+un);
           System.out.println("password :"+pw);
           if(un.equals("") || pw.equals("") ){
                   out.print("null");
           }
           else if(un.equalsIgnoreCase("hello") && pw.equals("world"))
           {

                    out.print("success");

           }

           else{
                   out.print("failed");
           }
           System.out.println("after :");
           request.getAttribute("USER"+un);
           request.getAttribute("PASS"+pw);
           RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);

           }catch(Exception e){
                   System.out.println("inside exception");
                   e.printStackTrace();
           }
           finally {            
               out.close();
           }
       }
     @Override
       protected void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
           service(request, response);
       }
     @Override
       protected void doPost(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
             service(request, response);
       }
     @Override
       public String getServletInfo() {
           return "Short description";
     }}
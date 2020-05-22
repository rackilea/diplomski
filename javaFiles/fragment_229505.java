public class ExampleServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


                Session MyObject = new Session();
                 boolean myParam=MyObject.getLogStat();  



  String s1 = Boolean.toString(myParam);


       try {


        request.setAttribute("I_WANT_TO_TEST", s1);

        RequestDispatcher view = request.getRequestDispatcher("My.jsp");
        view.forward(request, response); 


         } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }}
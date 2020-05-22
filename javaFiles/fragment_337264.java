public class EXAMPLE_SERVLET extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      String option= request.getParameter("book");


        BookData dao = new BookData();
        List<BookData> list = dao.loadData(option);

        request.setAttribute("booklist", list);

        RequestDispatcher view = request.getRequestDispatcher("test.jsp");
        view.forward(request, response); 

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



    }



}
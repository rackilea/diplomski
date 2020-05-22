public class SearchAttendServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Attendance> arrSub = new ArrayList<Attendance>();

        // ...

        request.setAttribute("attendRecord", arrSub);
        request.getRequestDispatcher("/WEB-INF/yourpage.jsp").forward(request, response);
    }

}
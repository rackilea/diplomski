public class servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = "some text";
        System.out.println(String.format("Lat: %s Long: %s", request.getParameter("lat"), request.getParameter("lng")));
    }

}
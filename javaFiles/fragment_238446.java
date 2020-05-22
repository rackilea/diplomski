public class MyServlet extends HttpServlet {

    protected Config config = new Config();

    @Override 
    public void doGet(request, response) throws ServletException{

        Strign s = config.getProperty("myParam");

    }

}
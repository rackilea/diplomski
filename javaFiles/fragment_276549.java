public class MyAwesomeServlet extends HttpSerlvet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        // ...

        runSlowProcess();
        // no async support, thread will be free when runSlowProcess() and
        // doGet finish

        // ...
    }

}
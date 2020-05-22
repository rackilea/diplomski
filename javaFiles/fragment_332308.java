public class HelloServlet extends HttpServlet {
    private static Executor logExecutor = Executors.newFixedThreadPool(5);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String data = String.format("a=%s b=%s c=%s",
                req.getParameter("a"), req.getParameter("b"),
                req.getParameter("c"));
        logExecutor.execute(new Task(data));
    }
}

class Task implements Runnable {
    private String data;

    public Task(String data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println(data);
    }
}
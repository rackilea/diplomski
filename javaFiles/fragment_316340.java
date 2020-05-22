public class Servlet2 extends HttpServlet {

    private final ExecutorService threadPool = Executors.newSingleThreadExecutor();
    private Future<String> calculationResult;

    @Override
    public void init() throws ServletException {
        calculationResult = threadPool.submit(new PreComputingTask());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String slowResponse = calculationResult.get();
        //...
    }
}

class PreComputingTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        //Call external systems, whatever...
        return "slow response";
    }
}
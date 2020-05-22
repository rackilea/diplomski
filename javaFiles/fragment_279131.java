@WebServletContextListener
public class SlowWebService implements ServletContextListener, Runnable {
    private volatile boolean running;
    ExecutorService executor;
    Thread runner;
    Queue<AsyncContext> jobQueue;

    public void contextInitialized(ServletContextEvent sce) {
        jobQueue = new ConcurrentLinkedQueue<AsyncContext>();
        sce.getServletContext().setAttribute("slowWebServiceJobQueue", jobQueue);
        // pool size matching Web services capacity
        executor = Executors.newFixedThreadPool(10);
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        running = true;
        while(running)
        {
            try {
                if(!jobQueue.isEmpty())
                {
                    final AsyncContext aCtx = jobQueue.poll();
                    executor.execute(new Runnable(){
                        public void run() {
                            ServletRequest request = aCtx.getRequest();
                            // get parameteres
                            // invoke a Web service endpoint
                            // set results
                            aCtx.forward("/result.jsp");
                        }
                    });
                }
            }
            catch (InterruptException e) {
            }
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        running = false;
        runner.interrupt();
        executor.shutdown();
    }
}
@WebListener
public class StartUpListener implements ServletContextListener {

    private static final Logger logger = Logger.getLogger(StartUpListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("********* context Refreshed **********");

        new Thread(new Runnable() {
            public void run(){
                try {
                    TimeUnit.SECONDS.sleep(10);
                    URL url = new URL ("http://localhost:8080/myapp/loadFeature");
                    URLConnection con = url.openConnection();
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        logger.info(inputLine);
                    }
                    in.close();
                } catch (Exception e) {
                    logger.error(e);
                }
            }
        }).start();

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("********* context contextDestroyed **********");
    }

}
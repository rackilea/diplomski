public void contextInitialized(ServletContextEvent sce) {   
//Some init code not relevant, omitted for clarity
  BidPushThread t= new BidPushThread();
  t.setServletContext(sce.getServletContext());
  t.start();// run();
}
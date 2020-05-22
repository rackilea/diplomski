@Override
    public void contextDestroyed(ServletContextEvent arg0) {

    if (connection != null || pcf != null) try {
          connection.close();
    //pcf.stop();
    }
    catch (JMSException e) {
         //log
    }
Hashtable<String, String> pdEnv = new Hashtable<String, String>();
pdEnv.put(Context.INITIAL_CONTEXT_FACTORY,"com.ibm.websphere.naming.WsnInitialContextFactory");             
pdEnv.put(Context.PROVIDER_URL, "iiop://localhost:2810");

Context initialContext = new InitialContext(pdEnv);
DataSource datasource = (DataSource) initialContext.lookup("testDS");

if (datasource != null) {
  connection = datasource.getConnection("admin","admin"); // DB credintials
} else {
  LOGGER.info("Failed to lookup datasource.");
}
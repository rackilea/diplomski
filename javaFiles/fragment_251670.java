public boolean checkForConnection() {
Handle handle = null;
try {
  jdbi = factory.build(environment, config.getDatabaseFactory(), "postgresql");
   handle = jdbi.open();
} catch (Exception e) {
  LOGGER.error("Error while checking Postgres connection.");
  return false;
} finally {
  try {
    if(handle != null){
      handle.close();
    }
  } catch (Exception e){
    LOGGER.error("Error trying to close connection");
    return false;
  }
}
return true;
}
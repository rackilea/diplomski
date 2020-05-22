...
finally {
if (connection != null) {
    try {
        connection.close();
        logger.debug("Connection broken.");
        Thread.sleep(1000);
    } catch (SQLException e) {
        logger.debug(e.getMessage());
        e.printStackTrace();
        fail("The connection could not be closed.");
    } catch (InterruptedException e) {
        logger.debug(e.getMessage());
        e.printStackTrace();

    }
...
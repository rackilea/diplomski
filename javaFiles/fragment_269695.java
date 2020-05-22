try {
    connection = pool.getInstance();
    connection.beginTransaction();
    processFile(connection, ...);
    connection.endTransaction();
    logger_multiThreaded.info("Done processing file: " + ... );
} catch (IOException e) {
    logger_multiThreaded.severe("Failed to process file: " + ... );
    e.printStackTrace();
} finally {
    if (connection != null) {
        pool.releaseInstance(connection);
    }
}
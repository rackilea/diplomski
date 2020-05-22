public static synchronized SqlSession getSqlBatchSession() {
    ConnectionBuilderAction connection = new ConnectionBuilderAction();
    sf = connection.getConnection();
    SqlSession session = sf.openSession(ExecutorType.BATCH);
    return session;
}

SqlSession session = ConnectionBuilderAction.getSqlSession();
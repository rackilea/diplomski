try {
    session.doWork(conn ->
            conn.createStatement().execute("ALTER SESSION SET COMMIT_LOGGING='BATCH' COMMIT_WAIT='NOWAIT'")
    );
    return callback.apply(session);
} finally {
    session.doWork(conn ->
            conn.createStatement().execute("ALTER SESSION SET COMMIT_LOGGING='IMMEDIATE' COMMIT_WAIT='WAIT'")
    );
}
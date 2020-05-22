private static final int NUM_THREADS = 8; // Can get from runtime to scale to number of cores
private static final ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

String sql = "select path, job_id from job_table where status = 'NEW' and rownum <= 5 order by created_date"; 

try {
    List<Future<?>> futures = new ArrayList<>();
    try (
        Connection conn = getConnection();
        PreparedStatement preparedStatement = conn.preparedStatement(sql);
        ResultSet rows = preparedStatement.executeQuery()
    ) {
        while(rows.next())
        {
            // Getting values from ResultSet here, to not assume thread-safety of ResultSet
            final String path = rows.getString("path");
            final int job_id = rows.getInt("job_id");
            futures.add(executor.submit(new Runnable() {
                @Override
                public void run() {
                    // do stuff or call respective methods depending on the values received from resultset.
                }
            });
        }
    }
    // Wait until all finished, database is already release while background processing is still ongoing
    for(Future<?> future : futures) future.get();
} catch(...) {
    ...
}
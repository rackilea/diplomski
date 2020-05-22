final ExecutorService executor = Executors.newCachedThreadPool();
    final Future<ResultSet> futureResult1 = executor.submit (new SqlTask("SELECT * FROM table1"));
    final Future<ResultSet> futureResult2 = executor.submit(new SqlTask("SELECT * FROM table2"));
    final Future<ResultSet> futureResult3 = executor.submit(new SqlTask("SELECT * FROM table3"));
    final ResultSet result1 = futureResult1.get();
    final ResultSet result2 = futureResult2.get();
    final ResultSet result3 = futureResult3.get();
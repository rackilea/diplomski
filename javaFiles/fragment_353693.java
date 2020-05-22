{...
 ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_CONCURRENT_THREADS);
 CompletionService<String> completionService = new ExecutorCompletionService (executor);

 completionService.submit(new Runnable() {
    @Override
    public void run() {
        inboundJdbcTemplate.query(selectQuery, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                try {
                    buffer.put(buildDP(rs, Id));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
 }, "Success");

 try{
      Future<String> take1 = completionService.take();
      String s = take1.get();
      if(!"Success".equals(s)) throw new RuntimeException("Error Occured");
 catch (InterruptedException | ExecutionException e) {
        LOG.error(" Could not execute DataExtraction",e);}
 executor.shutdown();
...}
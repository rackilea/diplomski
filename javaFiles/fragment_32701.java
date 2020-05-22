private final static Executor immediateExecutor = Runnable::run;

try ( Connection connection = pool.getConnection() ) {
   int timeout = connection.getNetworkTimeout();
   connection.setNetworkTimeout(immediateExecutor, TimeUnit.SECONDS.toMillis(5));
   ...
   try (PreparedStatement...) {
      ...
   }
   finally {
      connection.setNetworkTimeout(timeout);
   }
}
finally {
   ...
}
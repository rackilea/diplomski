public void doWorkOnConnection(Session session) {
  session.doWork(new Work() {
    public void execute(Connection connection) throws SQLException {
      //use the connection here...
    }
  });
}
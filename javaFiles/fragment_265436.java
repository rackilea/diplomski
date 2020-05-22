for (int i = 0; i < noOfTasks * noOfThreads; i++) {
  // add following line
  int userId = id.getAndIncrement();

  for (String arg : tableNames) {
      String url = (String) prop.get(arg + ".url");
      String user = (String) prop.get(arg + ".user");
      String password = (String) prop.get(arg + ".password");
      String driver = (String) prop.get(arg + ".driver");
      String suffix = (String) prop.get(arg + ".suffix");
      String sql = (String) prop.get(arg + ".sql");

      service.submit( new Task(id, url, user, password, driver, sql, suffix));
    }
}
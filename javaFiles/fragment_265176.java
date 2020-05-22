try {
  Class.forName("org.postgresql.Driver");
  //on classpath
} catch(ClassNotFoundException e) {
  //not on classpath
}
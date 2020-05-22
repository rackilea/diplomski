static {
  try {
    DriverManager.registerDriver(new org.postgresql.Driver());
  } catch(SQLException ex) {
    LogFactory.getLogger(AbstractDAO.class).error("Could not load Driver", ex);
  }
}
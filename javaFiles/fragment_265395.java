class TunneledHikariDataSource extends HikariDataSource implements InitializingBean {
  private boolean createTunnel = true;
  private int tunnelPort = 3306;

  public void afterPropertiesSet() {
    if(createTunnel) {
      // 1. Extract remote host name from the JDBC URL.
      // 2. Extract/infer remote tunnel port (e.g. 3306)
      // from the JDBC URL.
      // 3. Create a tunnel using Jsch and sample code
      // at http://www.jcraft.com/jsch/examples/PortForwardingL.java.html
      ...
    }
  }
}
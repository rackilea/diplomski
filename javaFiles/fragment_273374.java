play.db {
  # The combination of these two settings results in "db.default" as the
  # default JDBC pool:
  config = "db"
  default = "default"

  # Play uses HikariCP as the default connection pool.  You can override
  # settings by changing the prototype:
  prototype {
    # Sets a fixed JDBC connection pool size of 50
    #hikaricp.minimumIdle = 50
    #hikaricp.maximumPoolSize = 50
  }
}
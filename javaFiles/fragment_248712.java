package de.scrum_master.app;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class SubClassOverridingMethods extends BaseClass implements DataSource {
  @Override
  public Connection getConnection() throws SQLException {
    return super.getConnection();
//    return null;
  }

  @Override
  public Connection getConnection(String username, String password) throws SQLException {
    return super.getConnection(username, password);
//    return null;
  }
}
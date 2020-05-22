package de.scrum_master.query;

public class DatabaseQuery {
  private String request;

  public DatabaseQuery(String request) {
    this.request = request;
  }

  public String executeQuery(String request) {
    return request.toUpperCase();
  }

  public String getResult() {
    return executeQuery(request);
  }
}
package de.scrum_master.requests;

import de.scrum_master.query.DatabaseQuery;

public class RequestProcessor {
  private String request;
  private DatabaseQuery databaseQuery;

  public RequestProcessor(String aRequest) {
    this.request = aRequest;
    databaseQuery = new DatabaseQuery(request);
  }

  public String processRequest() {
    return executeRequest();
  }

  private String executeRequest() {
    return databaseQuery.executeQuery(request);
    //return databaseQuery.getResult();
  }

  public void setDatabaseQuery(DatabaseQuery databaseQuery) {
    this.databaseQuery = databaseQuery;
  }
}
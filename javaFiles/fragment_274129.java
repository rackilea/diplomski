package ua.com.alistratenko.dao;

public class Session {
  public QueryResult createQuery(String string) {
    return new QueryResult();
  }

  public void close() {}
}
package ua.com.alistratenko.dao;

public class SessionFactory {
  public Session openSession() {
    return new Session();
  }
}
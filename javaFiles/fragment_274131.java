package ua.com.alistratenko.dao;

import java.util.List;

public class UserDaoImp {
  private SessionFactory sessionFactory = new SessionFactory();
  private Session session;

  public SessionFactory getSessionFactory() { return sessionFactory; }
  public Session getSession() { return session; }
  public void setSession(Session session) { this.session = session; }

  public List<User> listUsers() {
    return session.createQuery("from User").list();
  }

  public static void main(String[] args) {
    new UserDaoImp().listUsers();
  }
}
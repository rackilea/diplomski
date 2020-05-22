package ua.com.alistratenko.dao;

import java.util.ArrayList;
import java.util.List;

public class QueryResult {
  public List<User> list() {
    List<User> users = new ArrayList<>();
    users.add(new User("jane"));
    users.add(new User("joe"));
    return users;
  }
}
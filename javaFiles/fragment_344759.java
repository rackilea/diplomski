package main;

import java.util.ArrayList;


//no need to implement Iterator, since you only add element 
//to an arraylist and nothing else.
public class UserGroup2 {

private ArrayList<User> administrators = new ArrayList<>();

public UserGroup2() {
  addUser(new User("lnb1g16", "Student", "Lee"));
  addUser(new User("hpf1g17", "Staff", "Harry"));
  addUser(new User("jks1g25", "Student", "Jordon"));
  addUser(new User("ohw1237", "Admin", "Oliver"));
  addUser(new User("ahs1213", "Student", "Jordon"));
  addUser(new User("bdh1285", "Admin", "Bob"));
  addUser(new User("tqn1294", "Student", "Taylor"));
}

public void addUser(User inUser) {
  this.administrators.add(inUser);
}

public ArrayList<User> getAdministrators() {
    return administrators;
}

}
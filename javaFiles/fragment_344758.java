package main;


public class User {
  //Set the members of this class to private
  //This is to ensure encapsulation 
  private String username;
  private String userType;
  private String name;

  User(String username, String userType, String name) {
    this.username = username;
    this.userType = userType;
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public String getUserType() {
    return userType;
  }

  public String getName() {
    return name;
  }

  //Set the usertype using the admin parameter
  //instead of the string admin
  //otherwise all the users will be admin
  public String setUserType(String admin) {
    return userType = admin;
  }

  @Override
  public String toString() {
    return username + " " + userType;
  }    
}
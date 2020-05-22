package main;

public class Main{
 public static void main(String[] args) {
    System.out.println("***********Iteration of administrators***********");

    //Create the user group
    UserGroup2 userGroupObject2 = new UserGroup2();

    //Get and iterate over the arraylist inside usergroup2
    for (User currentUser : userGroupObject2.getAdministrators()) {
      //Compare the current user to the username we are searching for
      if (currentUser.getUsername().equals("jks1g25"))
        System.out.println(currentUser.toString());
    }
  }
}
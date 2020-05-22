public static void changeDetails(String firstName, String lastName, String email, String password, String age, String nationality)
  {
    Logger.info("New details are: " + firstName + " " + lastName + " " + email + " " + password + " " + age + " " + nationality + " ");

    //here you are creating new user object and setting it`s properties, wrong
    User user = new User(firstName, lastName, email, password, age, nationality); 
    user.save();
    Home.index();
  }
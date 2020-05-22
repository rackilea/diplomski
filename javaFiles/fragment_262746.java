public static void changeDetails(User user, String firstName, String lastName, String email, String password, String age, String nationality)
  {
    Logger.info("New details are: " + firstName + " " + lastName + " " + email + " " + password + " " + age + " " + nationality + " ");

    user.firstName = firstName;
    user.lastName = lastName;
    user.email = email; 
    user.password = password; 
    user.age = age; 
    user.nationality = nationality;

    Home.index();
  }
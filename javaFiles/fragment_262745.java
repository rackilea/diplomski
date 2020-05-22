public static void changeDetails(User user, String firstName, String lastName, String email, String password, String age, String nationality)
  {
    Logger.info("New details are: " + firstName + " " + lastName + " " + email + " " + password + " " + age + " " + nationality + " ");

    user.setfirstName(firstName);
    user.setlastName(lastName);
    user.setEmail(email); 
    user.setPassword(password); 
    user.setAge(age); 
    user.setNationality(nationality);

    Home.index();
  }
/**
  * Class to generate the username based on user's first name and 
   randomly generated numbers
    */
   public void username(fullName)
   {
    // create random object and variable to store it in
    Random randomizer = new Random();
    int randomNumber = randomizer.nextInt(1000);
    // create variable to store lowercase username
    String lowercase = (fullName.toLowerCase());
    // create string variable to format username to first three characters in lowercase
    String firstThreeLetters = (lowercase.substring(0, 3));
    // concatenate lowercase characters and random number
    String usernameFinal = (firstThreeLetters + randomNumber);
    // print out final username
    System.out.println("Your username is " + usernameFinal);
}
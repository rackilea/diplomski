public static void main(String args[])
{
    Dog myDog = new Dog("Rover"); //myDog contains STRING1 ("Rover")
    String dogName = myDog.getName(); //dogName is set to refer to STRING1 ("Rover")
    myDog.setName("Max"); //myDog name set to STRING2 ("Max") (STRING1 unaffected)
    System.out.println(dogName); //dogName still refers to STRING1 ("Rover"), "rover" printed
}
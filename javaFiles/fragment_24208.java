public class DogOwnerTester {

     public static void main(String[] args) {

    List<Dog> dogList = new ArrayList<>(); // This list should be in user's class.
    Scanner input = new Scanner(System.in);

    //Create the owner object.
    Owner owner = new Owner(......); //Fill in the arguments



System.out.println("Would you like to add a dog? (Enter 'Y' or 'N')");
String add = input.next();

while (add.equalsIgnoreCase("y")) {
    System.out.println("Please enter the name of the dog: ");
    String name = input.next();
    System.out.println("Please enter the category of the dog: ");
    String category = input.next();
    System.out.println("Please enter the age of the dog: ");
    int age = input.nextInt();
    // System.out.println("Who is the dog's owner? ");
    // Somehow assign the owner to the dog using scanner?;

    Dog dog = new Dog(name, category, age, null);


    dogList.add(dog); // This should not be here.
    owner.addDogToList(dog);  //Call the owner's function to add the dog.

    System.out.println("Would you like to create another dog?(Enter 
            'Y' or 'N')");
    add = input.next();

    }
}
}
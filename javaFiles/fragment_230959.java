import java.util.Scanner;
public class MyPet_1_lab7 {
    // Implement the class MyPet_1 so that it contains 3 instance variables
        private String breed;
        private String name;
        private double age; // instead of private int age;

        MyPet_1_lab7 dog1;
        MyPet_1_lab7 dog2;

    // Default constructor
        public MyPet_1_lab7()
        {
            this.breed = null;
            this.name = null;
            this.age = 0;
        }
    // Constructor with 3 parameters
        public MyPet_1_lab7(String a_breed, String a_name, double an_age){
            this.breed = a_breed;
            this.name = a_name;
            this.age = an_age;
        }
    // Accessor methods for each instance variable
        public String getBreed(){
            return this.breed;
        }
        public String getName(){
            return this.name;
        }
        public double getAge(){
            return this.age;
        }
    //Mutator methods for each instance variable
        public void setBreed(String breed2){
            this.breed = breed2;
        }
        public void setName(String name2){
            this.name = name2;
        }
        public void setAge(double age2){
            this.age = age2;
        }
    // toString method that will return the data in an object formated as per the output
        public String toString(){
            return (this.breed + " whose name is " + this.name + " and " + this.age + " dog years (" + inHumanYears() + " human years old)");
        }
        public boolean equals(MyPet_1_lab7 a){
            if ((this.breed.equals(a.getBreed())) && (this.age == a.getAge())){
                return true;
            }
            else
                return false;
        }
        double human_age = 0;
        public double inHumanYears(){
            if (this.age < 1)
                human_age = (this.age) * 15;
            if (this.age >=1 && this.age < 2)
                human_age = 15 + (this.age - 1) * 9;
            if (this.age >= 2 ){
                human_age = 15 + 9 + (age - 2)*5;
                }

            return human_age;
        }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner (System.in);
        System.out.print("What type of dog do you have? ");
        String breed = keyboard.nextLine();

        System.out.print("What is its name? ");
        String name = keyboard.nextLine();

        System.out.print("How old? ");
        double age = keyboard.nextDouble();
        MyPet_1_lab7 dog= new MyPet_1_lab7();
        System.out.println(dog);
        MyPet_1_lab7 dog1 = new MyPet_1_lab7(breed,name,age);
        System.out.println(dog1);

        Scanner key = new Scanner(System.in);
        System.out.println("\nLet's set up the 1st dog ... ");
        System.out.print("\tWhat breed is it? ");
        String breed1 = key.nextLine();

        System.out.print("\tWhat is the dog's name? ");
        String name1 = key.nextLine();

        System.out.print("\tHow old is the dog in dog years (a double number)? ");
        double age1 = key.nextDouble();
        MyPet_1_lab7 dog2 = new MyPet_1_lab7 (breed1, name1, age1);
        System.out.println("Dog1 is now a(n) " + dog2);

        System.out.println("\nAre the 2 dogs the same breed and age?");
        if ((breed.equals(breed1))&& age == age1)
            System.out.println("Yes, they are the same breed and age");
        else 
            System.out.println("No, they are not the same breed and/or age");
    }
}
'''
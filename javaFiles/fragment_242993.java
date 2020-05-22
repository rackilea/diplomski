import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class Main {

    //This is out Human class. I would suggest moving this outside of your Main class, but did it this way for simplicity's sake
    public static class Human {

        //This is our list of names we can choose from if we are not given one on construction. It uses Java's Arrays.asList to create the list, similar to using new ArrayList() followed by several .add statements
        private static final List<String> NAMES = Arrays.asList("Alex", "Billy", "Charlie", "Dan", "Eddie", "Fred", "Greg", "Harry", "Ian");

        //Our private class variables
        private final String name;
        private final int age;

        // No args constructor. This will generate a random number for an age(0-99), and randomly select one of our names by its index in the list by way of Java's Random class
        public Human(){
            Random random = new Random();
            this.age = random.nextInt(99);
            this.name = NAMES.get(random.nextInt(NAMES.size()));
        }

        //Arg constructor
        public Human(int age, String name){
            this.age = age;
            this.name = name;
        }

        //toString method, so we can print out the contents of our human
        @Override
        public String toString(){
            return "Age: " + this.age + " Name: " + this.name;
        }

    }

    public static void main(String[] args){
        //Random humans
        System.out.println(new Human());
        System.out.println(new Human());
        System.out.println(new Human());

        //Human with params
        System.out.println(new Human(1, "Joe"));
    }
}
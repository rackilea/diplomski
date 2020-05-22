public class Animal {
   public String foodtype;
   //other members
}

public class Dog extends Animal {
   public String name;
   //other members
}

public class Test {

   public static void main(String[] args) {
        Animal a = new Dog();//'a' can access Anmial class members only
        a.foodtype = "meat"; //ok
        a.name = "puppy"; //compiler error

        Dog d = new Dog();//'d' can access both Animal and Dog class members
        d.foodtype = "meat"; //ok
        d.name = "puppy";//ok
   }
}
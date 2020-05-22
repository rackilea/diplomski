class Fruit{
     private final String name; 
     public Fruit(String name){ 
         if (/* name has an incorrect value, is null or whatever */) 
             throw new IllegalArgumentException("name");
         this.name = name; 
     }
}

//Apple wants to get an error if it does not use the name variable
class Apple extends Fruit {
     public Apple(){ super("Apple"); }
}
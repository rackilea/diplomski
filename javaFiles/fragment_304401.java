public class Food {

    //field that stores the name of the food
    public String name; 

    //constructor that takes the name of the food as an argument
    public Food(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Meat extends Food 
{
    public Meat(String name) {
        super(name);
    }

    public String getName() {
        return super.getName();
    }
}


public class Main {
    public Main() {
        super();
    }

    public static void main(String[] args) {
        Wolf wolfExample = new Wolf();        
          System.out.println("************Wolf\"************");
          System.out.println("Name = " + wolfExample.getName());
          System.out.println("Age = " + wolfExample.getAge());
          wolfExample.makeNoise();
          System.out.println("Noise = " + wolfExample.getNoise());

        try {            
            Meat meatExample = new Meat("Steak");
            //Food vegFood =  new Food("Spinach");
                    System.out.println("************Wolf eating habits************");
            wolfExample.eat(meatExample);
            //wolfExample.eat(vegFood);

        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }
}
public interface Runs {
     public void run();
}

public class Cat implements Runs {
     int numLegs;
     public Cat() {
          this.numLegs = 4;
     }
     public void run() {
          System.out.println("does whatever running cats do");
     }
}

public class Human implements Runs {
     int numLegs;
     public Human() {
          this.numLegs = 2;
     }
     public void run() {
          System.out.println("does whatever running humans do");
     }
}
 public class Main {
         public static void main(String[] args) {
              Cat cat = new Cat();
              Human human = new Human();

              ArrayList<Runs> listOfRunners = new ArrayList<Runs>();
              listOfRunners.add(cat);
              listOfRunners.add(human);
              Runs runner = listOfRunners.get(0);
              /* no compiler error because by implementing Runs we guarantee it has run() method */
              runner.run();
              runner = listOfRunners.get(1);
              /* It doesn't matter what the object is. We don't care if it is cat or human */
              runner.run();
         }
    }
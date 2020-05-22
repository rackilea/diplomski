public interface Walkable {
   void abstract walk();
} 

public interface Feedable {
   void eat();
} 

public Robot implements Walkable {
   public void walk() {
     //walk at 10km/h speed
   }
}

public Human implements Walkable, Feedable {
   public void walk() {
     //walk at 5km/h speed
   }

   public void eat(){
     //...
   }    
}
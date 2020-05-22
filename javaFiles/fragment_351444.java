public abstract class Biped {  
  public void abstract walk();
} 

public Robot extends Biped {
   public void walk() {
     //walk at 10km/h speed
   }
}

public Human extends Biped {
   public void walk() {
     //walk at 5km/h speed
   }
}
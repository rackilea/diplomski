public interface Room {
  Cleaner<? extends Room> cleanerInstance();
}

public class Bathroom implements Room {
  public Cleaner<Bathroom> cleanerInstance(){
    return new BathroomCleaner();
  }
}
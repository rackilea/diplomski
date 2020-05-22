public abstract class DogKennel {
  protected List<Dog> dogs = new ArrayList<Dog>();
}

public class GreyHoundKennel extends DogKennel {

  // Force an interface that only allows what I want to allow
  public void addDog(GreyHound greyHound) { dogs.add(greyHound); }

  public List<Dog> getDogs() {
    // Greatly reduces risk of side-effecting and thread safety issues
    // Plus, you get the generic list that you were hoping for
    return Collections.unmodifiableList(this.dogs);
  }

}
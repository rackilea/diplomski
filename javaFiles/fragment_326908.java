// Original code starts here.
public interface DogKennel {
  public List<Dog> getDogs();
}

public class GreyHoundKennel implements DogKennel {

  protected List<GreyHound> greyHounds;

  public List<GreyHound> getGreyHounds() {
    return this.greyHounds;
  }
// Original code ends here

  public List<Dog> getDogs() {
    // This line eliminates the thread safety issue in returning 
    // an internal reference.  It does use additional memory + cost
    // CPU time required to copy the elements.  Unless this list is
    // very large, it will be hard to notice this cost.
    return new ArrayList<Dog>(this.greyHounds);
  }

}
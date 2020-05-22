public class Zoo<T> {
  private List<? extends Cage<? super T>> cages = new ArrayList<>();

  public void addAnimal(String cageName, T animal) {
    for(Cage<? super T> cage : cages) {
      // Now you can add animal to a cage
    }
  }
}
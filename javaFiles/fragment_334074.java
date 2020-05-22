public class Sheep {
  private String name;
  private Fur fur;
  private Eye[2] eyes;
  //...

  // the copy constructor
  public Sheep(Sheep sheep) {
    // String already has a copy constructor ;)
    this.name = new String(sheep.name);

    // assuming Fur and Eye have copy constructors, necessary for proper cloning
    this.fur = new Fur(sheep.fur); 
    this.eyes = new Eye[2];
    for (int i = 0; i < 2; i++) 
       eyes[i] = new Eye(sheep.eyes[i]);
  }
}
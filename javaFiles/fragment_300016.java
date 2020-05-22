public class ConstructorTest {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // get the id and name from the scanner (I would suggest using prompts)
    String name = in.nextLine();
    int id = in.nextInt();

    // create an object:
    ConstructorTest myObject = new ConstructorTest(id, name);

    // call the method:
    String myString = myObject.toString();

    // print the result:
    System.out.println(myString);
  }

  // private variables, effectively the "properties" stored by the object:
  private int id;
  private String name;

  // constructor:
  public ConstructorTest(int id, String name) {
    this.id = id;
    this.name = name;
  }

  // method
  @Override // because this is a method in java.lang.Object and we're overriding it
  public String toString() {
    return id + " - " + name;
  }
}
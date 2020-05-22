public class MyClass {
  private List<String> names;
  private List<String> categories;
  ...

  public MyClass () {
     names = new ArrayList<String>();
     categories = new ArrayList<String>();
     ...

  public newItem () {     
     Scanner scan = new Scanner(System.in);
      System.out.println("Name:");
      String nameInput = scan.next();
      System.out.println("Category:");
      String categoryInput = scan.next();
      names.add(nameInput);
      categories.add(categoryInput);
      System.out.println("newItem: " + nameInput + " " + categoryInput);
  }
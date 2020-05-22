class Dog
{
  public String name;
  Dog(String n) { name = n; }
  public void talk() { System.out.println("Dog " + name + " barks!"); }
  public void walk() { System.out.println("Dog " + name + " walks..."); }
}
class Cat
{
  String name;
  Cat(String n) { name = n; }
  public void talk() { System.out.println("Cat " + name + " meows!"); }
  public void walk() { System.out.println("Cat " + name + " walks..."); }
}
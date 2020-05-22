public class Student extends Person {
  public String somethingnew;

  public Student(String name) {
    super(name);
    somethingnew = "surprise!";
  }

  public String toString() {
    return super.toString() + "\t" + somethingnew;
  }

  public static void main(String[] args) {
    Person you = new Person("foo");
    Student me = new Student("boo");

    System.out.println("Your name is " + you);
    System.out.println("My name is " + me);
  }
}
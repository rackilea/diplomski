public abstract class Person {    //Person abstract class
   public String firstName;
   public String lastName;
   public char gender;

   public Person(String fname, String lname, char g) { //constructor
      firstName = fname;
      lastName = lname;
      gender = g;
   }
   public abstract void setDefaults();
}

public class Employee extends Person {   //Employee class that extends Person

   public Employee(String fname, String lname, char g) {    //i thought super(); might solve the problem, but it didnt.
      super(fname, lname, g);
   }
   public void setDefaults() {}
}
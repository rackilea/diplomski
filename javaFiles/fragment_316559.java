public class Person implements Serializable {
    ...
  @Override
  public String toString() { 
     return String.format(firstName + " " + lastName + "("+ lastName + firstName + ")"); 
  } 
}
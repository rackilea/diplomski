class Person {

//Respective Constructor, Getter & Setter methods


/* Returns the string representation of Person Class. 
 * The format of string is firstName lastName (lastNameFirstName)*/

  @Override
  public String toString() { 
    return String.format(firstName + " " + lastName + "("+ lastName + firstName + ")"); 
  } 
}
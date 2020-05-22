//Here we declare that our class would have two fields.
//It also created primary constructor, which takes 2 arguments

class Person(val firstName: String, val lastName: String) {

  def this(firstName: String) { //second constructor
    this(firstName, "");
  }

  def this() { //third constructor
    this("");
  }
}
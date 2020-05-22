class Foo {
  public ArrayList<Person> people;

  Foo() {
    //this:
    ArrayList<Person> people = new ArrayList<Person>();
    //creates a new variable also called people!

    System.out.println(this.people);// prints "null"!
    System.out.println(people);//prints "bladiebla"
  }
  Foo() {
    people = new ArrayList<Person>();//this DOES work
  }
}
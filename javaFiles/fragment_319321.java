class Person {

  String age, name;

  List<String> hobbies;

  {
    hobbies = new ArrayList<String>();
  }

  public Person(String name, String age) {
    this.name = name;
    this.age = age;
  } 

}
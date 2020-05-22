class Person {
  private String mName;
  private int mAge;
  public Person(int age, String name) {
     mName = name;
     mAge = age;
  }
  public String getName() {
     return mName;
  }
  etc ........
}

ArrayList<Person> arr = new ArrayList<Person>();
arr.add(new Person(10, "joe"));
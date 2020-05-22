class SomeClass {
  private int i; //will be initialized to 0
  private Date date; //will be initialized to null
  private String s = "hello"; //will create a new String object with the value "hello" and assign that instance to variable s

  //the following block is an instance initializer block which is called before the constructor
  {
    date = new Date();
  }

  //This is a static initializer block which is called when the class is loaded,
  //but which cannot be used to initialize instances
  static 
  {
    System.out.println("class has been loaded");
  }
}
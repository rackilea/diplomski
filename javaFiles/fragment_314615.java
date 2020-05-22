public class Student {

  public String name; //name of student

  public Student(String name) {//Constructor for student, receiving name when u create new object Student
    this.name = name; //set received name to this public String name
  }


  /**
   * When u call this method you will get inputed name from constructor
   * so if u call Student stud = new Student("John");
   * new Student("John") is constructor!
   * with stud.getName(); you will get "John".
   * This is called getter.
   * @return name of student
   */
  public String getName() {
      return name;
  } 
}
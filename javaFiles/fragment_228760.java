public class Student {
  private String name;
  private String city;
  private String school;
  ....   

  public Student(String name, String city, String school) {
      this.name = name;
      this.city = city;
      this.school = school;
  }

   //getters & setters..
  public String setSchool(String school) {
      this.school = school;
  }

  public String getSchool() {
      return this.school;
  }

  public boolean equals(Object other) {
      if (other == null) return false;
      if (other == this) return true;

      if (!(other instanceof Student)) return false;
      Student s = (Student)other;

      if (s.getSchool().equals(this.getSchool())) {
          return true; // here you compare school name
      } 
      return false;
  }

  public String toString() {
      return  "Name: " + this.name + "\tCity: " + this.city + "\tSchool: "+ this.school;
  }
}
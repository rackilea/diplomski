class Student {
...

public Student(String name, String gender) {
    this.name = name;
    this.gender = gender;
    YourClass.addStudent(name, gender);
  }
}
public class Student{
    public String name, gender, password, course, modules;
    public int age;

Student(){ //constructor
    }

Student(String name, String gender, int age, String password, String course, String modules){ //constructor
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.password = password;
        this.course = course;
        this.modules = modules;
    }
}
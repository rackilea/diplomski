Student model2 = JSON.parseObject(hell, StudentTO.class).asStudent();
System.out.println(model2);

public class StudentTO {

    private String name;
    private String age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public Student asStudent() {
        return new Student(name, age);
    }
}
public class Employee {
    public String name;
    public Integer age;
    public Employee(){

    }
    public Employee(String [] args){
        this.name=args[0];
        this.age=Integer.parseInt(args[1]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
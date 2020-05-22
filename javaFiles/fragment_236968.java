public class Student {

private String name;
private int id;
private int balanace;

public Student(){}

public Student(String name, int id, int balance){
    this.name = name;
    this.id = id;
    this.balanace = balance;
}

public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public int getBalanace() {
    return balanace;
}
public void setBalanace(int balanace) {
    this.balanace = balanace;
}
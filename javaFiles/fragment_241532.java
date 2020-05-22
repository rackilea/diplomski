public class Student {

private int id;
private String name;

public Student(int id, String name){
    this.id = id;
    this.name = name;
}

    public int getID() {
        return id;
    }

    public void setID(int i) {
        this.id = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String toString() {
        return "The student's name is: " + this.name + "\n" +
               "The student's ID is: " + this.id;
    }

}
import java.util.Arrays;

class Person {
    String name;
    void Salary() {
        System.out.println("All positions are salaried");

    }
    public String toString(){
        return name;
    }
}

class Employee extends Person {

    void Salary() {
        System.out.println("Salaries vary between staff and supervisors");
    }
    public String toString(){
        return name;
    }

}

class Staff extends Employee {

    public Staff(String name) {
        this.name = name;
    }

    void Salary() {
        System.out.println("A regular staff employee makes 3500.00 monthly");
    }
    public String toString(){
        return name;
    }


}

class Supervisor extends Employee {

    public Supervisor(String name) {
        this.name = name;
    }

    void Salary() {
        System.out.println("Supervisors make approximately 9800.00 monthly");
    }
    public String toString(){
        return name;
    }
}

public class HRRoster {

    public static void main(String[] args) {

        Person roster[] = new Person[6];
        roster[0] = new Supervisor("James Martin");
        roster[1] = new Supervisor("William Smith");
        roster[2] = new Supervisor("Jennifer Shipman");
        roster[3] = new Staff("Brian Williams");
        roster[4] = new Staff("Carrie James");
        roster[5] = new Staff("Samantha Powers");

        for (int i = 0; i < roster.length; i++) {
            System.out.print(roster[i].toString() + "\t");
            roster[i].Salary();
        }
    }

}
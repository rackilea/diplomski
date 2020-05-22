static List<Employee> allEmployees = new ArrayList<>();

public class Employee {
    private double salary;
    private boolean hired;

    public Employee() {
        // All employees must register themselves in the allEmployees list.
        allEmployees.add(this);
    }

    public double getSalary() {return salary;}
    public double setSalary(double x) {salary=x;}

    public boolean getHired() {return hired;}
    public boolean setHired(boolean check) {hired=check;}

}

public class Boss extends Employee {

    public void fireTheGuy(Employee unluckyYou) {
        unluckyYou.setHired(false);
        unluckyYou.setSalary(0.0);
    }

    public void fireThese(Iterable<Employee> fireThem) {
        for ( Employee e : fireThem ) {
            fireTheGuy(e);
        }
    }

    public void fireEveryone() {
        fireThese(allEmployees);
    }
}
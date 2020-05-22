public class Manager extends Employee {

    protected double bonus;

    public Manager(String name, int id, double salary, int bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();

        return (baseSalary + baseSalary * (bonus / 100));

    }

    @Override
    public String toString() {
        return "Manager [name=" + name + ", id=" + id + ", salary=" + salary + ", bonus=" + bonus + "]";
    }

}
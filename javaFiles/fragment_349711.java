public class Manager extends Employee {

    public Manager(int id, String name, int salary) {
        super(id, name, salary);
    }

    @Override
    public String getName() {
        return "doppelganger";
    }

    public static void main(String[] args) {
        Employee e = new Manager(0, "Eric", 100); //e should be immutable right!
        System.out.println(e.getName()); // prints "doppelganger", I thought employee was immuatble!?
    }
}
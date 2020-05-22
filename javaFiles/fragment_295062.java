public class Company {
Employee[] employees;

    public Company (String[] names, String[] addresses, int[] ids, double[] salaries) {
        employees = new Employee[names.length];
        for (int i = 0; i < employee.length; i++) {
            employees[i] = new Employee (names[i], addresses[i], ids[i], salaries[i]);
        }
    }

    static class Employee {
    String name;
    String address;
    int id;
    double salary;

        Employee (String name, String address, int id, double salary) {
            this.name = name;
            this.address = address;
            this.id = id;
            this.salary = salary;
        }
    }
}
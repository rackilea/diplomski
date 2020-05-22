public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare (Employee e1, Employee e2) {
        // Note we're comparing e2 to e1 to get a descneding effect
        int salaryCompare = Double.compare(e2.getMonthlySalary(), e1.getMonthlySalary());
        if (salaryCompare != 0) {
            return salaryCompare;
        }

        // If the salaries are equal, compare names
        return e1.getName().compareTo(e2.getName());
    }
}
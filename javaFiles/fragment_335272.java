public class EmployeeComparator implements Comparator<Employee> {

    private final String type;

    public EmployeeComparator (String type) {
        this.type = type;
    }

    public int compare(Employee e1, Employee e2) {
        if (type.equals("name")) {
             return e1.getName().compareTo(e2.getName());
        }
        return e1.getId().compareTo(e2.getId());
    }

}
class Employee {
    private final int employeeID;
    private final int departmentID;
    private final int employedYears;
    private final String firstName;
    private final String lastName;

    public Employee(int eid, int d, int y, String fn, String ln) {
        employeeID = eid;
        departmentID = d;
        employedYears = y;
        firstName = fn;
        lastName = ln;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(employeeID);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o instanceof Employee) {
            return employeeID == ((Employee) o).employeeID;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s, %s %d %d %d", lastName, firstName, //
                employeeID, departmentID, employedYears);
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public int getEmployedyears() {
        return employedYears;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
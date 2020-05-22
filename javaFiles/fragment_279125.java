interface Employee {
    double getAllocation();
    EmployeeType getType();
}

class IndividualContributor implements Employee {
    private Manager boss;
    public double getAllocation() {
        return getType().getAllocation();
    }
}

class Manager implements Employee {
    private final List<Employee> staff;
    public double getAllocation() {
        return getType().getAllocation() + 300;
    }
}
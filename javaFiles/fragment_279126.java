enum EmployeeType {
    QA(500), 
    DEV(100),
    OTHER(250);

    private final double allocation;

    EmployeeType(double allocation) {
        this.allocation = allocation;
    }

    public double getAllocation() {
        return allocation;
    }
}
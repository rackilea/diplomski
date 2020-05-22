public abstract class Employee {
    public abstract double getMonthlySalary();
    // Rest of the members and methods you declared
}

public class EmployeeFixedPayment extends Employee {
    double fixedPayment;

    @Override
    public double getMonthlySalary() {
        return fixedPayment;
    }

    // Rest of the members, ctots, etc. you declared
}

public class EmployeeHourlyWage extends Employee {
    double hourlyWage;

    @Override
    public double getMonthlySalary() {
        return hourlyWage * 20.8 * 8;
    }

    // Rest of the members, ctots, etc. you declared
}
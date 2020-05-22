class Salary {
    double base;
    SalaryAdjustment[] adjustments;
    double getSalary() {
        double r = base;
        for (SalaryAdjustment a: adjustments) {
            r += a.getAdjustment();
        }
        return r;
    }
};
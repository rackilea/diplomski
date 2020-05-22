public class EmployeeGenerator {

    public ProductionWorker generateProductionWorker() {
        Random rng = new Random();
        int numberOfEmployeeNames = employeeNames.length;
        String employeeName = employeeNames[rng.nextInt(numberOfEmployeeNames)];
        int numberOfEmployeeNumbers = employeeNumbers.length;
        String employeeNumber = employeeNumbers[rng.nextInt(numberOfEmployeeNumbers)];
        ProductionWorker worker = new ProductionWorker(employeeName, employeeNumber);

        int yearHired = rng.nextInt(100) + 1900;
        worker.setHireYear(yearHired);

        int hourlyRate = rng.nextInt(20) + 10;
        worker.setHourlyRate(hourlyRate);

        // any other fields...
        return worker;
    }

    // method to generate shift supervisor
}
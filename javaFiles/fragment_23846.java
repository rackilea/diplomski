public static void main(String[] args) {
    Random rng = new Random();
    int numberOfEmployeesToGenerate = 1000;
    int minimumNumberOfProductionWorkers = numberOfEmployeesToGenerate / 2;

    int numberOfProductionWorkersToGenerate = 
        minimumNumberOfProductionWorkers + rng.nextInt(100);

    int numberOfSupervisorsToGenerator =
        numberOfEmployeesToGenerate - numberOfProductionWorkersToGenerate;

    List<Employee> employees = new ArrayList<>();
    EmployeeGenerator generator = new EmployeeGenerator();
    for (int i = 0; i < numberOfProductionWorkersToGenerate; i++) {
        ProductionWorker worker = generator.generateProductionWorker();
        employees.add(worker);
    }

    for (int i = 0; i < numberOfSupervisorsToGenerate; i++) {
        Supervisor supervisor = generator.generateSupervisor();
        employees.add(supervisor);
    }
}
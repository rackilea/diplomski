public Report() {
    try {
        EmployeeManager empManager = new EmployeeManager();
        TimeClockManager timeClockManager = new TimeClockManager();

        for (Employee emp : empManager.getEmployees()) {

            System.out.println("[" + emp.getId() + "] " + emp.getName());
            for (TimeClockEntry tce : timeClockManager.getByEmployee(emp)) {
                System.out.println("    "
                        + CLOCK_DATE_TIME_FORMAT.format(tce.getInTime())
                        + " to "
                        + CLOCK_DATE_TIME_FORMAT.format(tce.getOutTime()));
            }

        }

    } catch (IOException | ParseException exp) {
        exp.printStackTrace();
    }
}
public void deleteEmployee(Employee mitarbeiter) {
    if (mitarbeiter != null) {
        ManageEmployees.deleteEmployee(mitarbeiter.getEmployeeId());
        mitarbeiter = Queries.findAllEmployees();
    }
}
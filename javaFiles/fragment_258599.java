public void createEmployee(Employee employee) throws Exception {
    try {
        employee.setEmployeeName("alan");   
        employeeRepo.save(employee);
        employee.setEmployeeType("Permanent");  
        //employeeRepo.save(employee); <- not required : type should still be 'Permanent' in DB.
    } catch (Exception e) {
        throw new Exception(e);
    }

}
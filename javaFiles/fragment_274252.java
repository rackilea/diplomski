@POST
@Path("/addemployee")
@Consumes(MediaType.APPLICATION_JSON)
public void addEmployee(EmployeeVo employeeVo) {
    employeeDao.addNewEmployee(employeeVo);     
}
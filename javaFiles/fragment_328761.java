public Employee find(int empId) {

Employee emp = employeeDao.findOne(empId):

if(emp == null){

  throw new EntityNotFoundException("Employee does not exists for this Id");

} else if (emp !=null && emp.getDetails() ==null){

    throw new EntityNotFoundException("Employee Records does not exists for this Id");


} else return emp;

}
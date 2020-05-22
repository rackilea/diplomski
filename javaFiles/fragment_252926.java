EmployeeDto employeeDto =  new EmployeeDto();
employeeDto.setName(employee.getName());
employeeDto.setAddressLine1(employee.getAddressLine1());
if(employee.getAddressLine2()!=null && employee.getAddressLine2()!=""){
   employeeDto.setAddressLine2(employee.getAddressLine2());
}
employeeDto.setCity(employee.getCity());
employeeDto.setState(employee.getState());
employeeDto.setZip(employee.getZip());
employees.add(employeeDto);
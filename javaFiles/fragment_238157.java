@RequestMapping(value = "/employees/{id}")
public ResponseEntity<EmployeeVO> getEmployeeById (@PathVariable("id") 
int id) 
{
if (id <= 3) {
    EmployeeVO employee = new 
EmployeeVO(1,"Lokesh","Gupta","howtodoinjava@gmail.com");
    return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
}
return new ResponseEntity(HttpStatus.NOT_FOUND);
}
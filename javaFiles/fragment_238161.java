@RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
public ResponseEntity<EmployeeVO> updateEmployee(@PathVariable("id") 
int id, @RequestBody EmployeeVO employee) 
{
System.out.println(id);
System.out.println(employee);
return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
}
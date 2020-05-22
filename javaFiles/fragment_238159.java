@RequestMapping(value = "/employees", method = RequestMethod.POST)
public ResponseEntity<String> createEmployee(@RequestBody EmployeeVO 
employee) 
{
System.out.println(employee);
return new ResponseEntity(HttpStatus.CREATED);
}
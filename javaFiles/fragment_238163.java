@RequestMapping(value = "/employees/{id}", method = 
RequestMethod.DELETE)
public ResponseEntity<String> updateEmployee(@PathVariable("id") int 
id) 
{
System.out.println(id);
return new ResponseEntity(HttpStatus.OK);
}
private Department getDepartmentById(Long departmentId)
  throws InvalidDepartmentException {
  try {
    return entityManager.getReference( Department.class, departmentId );
  }
  catch ( EntityNotFoundException e ) {
    throw new InvalidDepartmentException( departmentId, e );
  }
} 

private List<Employee> getEmployeesNoAssociation(Long departmentId) 
  throws InvalidDepartmentException {
  final Department dept = getDepartmentById( departmentId );
  return entityManager
    .createQuery( "SELECT e FROM Employee e WHERE e.departmentId = :id", Employee.class )
    .setParameter( "id", dept.getId() )
    .getResultList();
}

private List<Employee> getEmployeesWithAssociation(Long departmentId) 
  throws InvalidDepartmentException {
  final Department dept = getDepartmentById( departmentId );
  return entityManager
    .createQuery( "SELECT e FROM Employee e WHERE e.department = :dept", Employee.class )
    .setParameter( "dept", dept )
    .getResultList();
}
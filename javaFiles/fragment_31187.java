@NamedQuery(name="empdetails", query="select e from Empl e where e.department.did=:did") 

Query q = session.getNamedQuery("empdetails").setInteger("did", 1); 
List<Employee> li = (List<Employee>)q.list(); 
for (Employee emp : li) { 
    System.out.println("Employee Name is "+emp.getEname()); 
    System.out.println("Employee Sal is " + emp.getSalary()); 
    System.out.println("Dept id is " + emp.getDpt().getDid()); 
}
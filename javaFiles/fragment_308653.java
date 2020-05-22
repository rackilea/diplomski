public List<Employee> getEmployees()
{
    List<Employee> list = new ArrayList<Employee>();
    list = template.loadAll( Employee.class );
    return list;
}
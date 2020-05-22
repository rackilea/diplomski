public Employee searchByEmail(String email) 
{
    for (Employee employee : map.values() {
        if (email.equals(employee.getEmail()) {
            return employee;
        }
    }
    return null;
}
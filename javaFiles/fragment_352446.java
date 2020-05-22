// Create my Hashtable using the diamond notation indicating  to use the type arguments
// corresponding to the context which is <String, Employee> here
Map<String, Employee> EmployeeTable = new Hashtable<>();
Employee employee = new Employee("Donald", 3, "Engineer");
// put my employee into my map using empoyee's name as key
EmployeeTable.put(employee.getEmpName(), employee);
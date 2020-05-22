// Use LinkedHashMap to keep insertion order
Map<String, Employee> employees = new LinkedHashMap<>();

// v1: add new employee with unique email
employees.putIfAbsent(employee.getEmail(), employee);

// v2: add new employee and show message for duplication email
if(employees.containsKey(employee.getEmail()))
    System.out.println("Email " + employee.getEmail() + " duplication");
else
    employees.put(employee.getEmail(), employee);

// get all employees in order they were added
List<Employee> res = new ArrayList<>(employees.values());
// replacing with 'employees' for 'employeeService.getAllEmployees()'
Comparator<Employees> compareBasedOnCity = 
            Comparator.comparing(emp -> emp.getAddress().getCity());
Comparator<Employees> compareBasedOnHouse = 
            Comparator.comparing(emp -> emp.getAddress().getHouseNumber());
employees.sort(compareBasedOnCity.thenComparing(compareBasedOnHouse));
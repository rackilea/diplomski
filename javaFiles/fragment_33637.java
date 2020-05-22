Set<Employee> employees = new HashSet<Employee>();
employees.add( new Employee("111"));
employees.add( new Employee("111"));

System.out.println(employees.size()); //1
employeeRepo.save(employees); // 1 record
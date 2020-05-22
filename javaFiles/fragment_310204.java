Employee emp = new Employee();
Department dep = new Department();
emp.setDepartment(dep);
dep.getEmployees().add(emp);
...
entityManager.merge(dep);
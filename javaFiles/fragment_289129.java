Employee emp = new Employee();
        emp.setEmployeeId(1);
        emp.setName("employee");

        Manager manager = new Manager();
        manager.setEmployee(emp);
        manager.setName("manager");

        Department department = new Department();
        department.setName("department");
        department.setManager(manager);

        em.persist(department);
String query = "SELECT new mypackage.CategorySalary( " +
    "    emp.category, " +
    "    emp.salary as somevalue, " +
    "    0 as dummy " +
    ") from ...  " +
    "WHERE ...  ";

TypedQuery<CustomEmployee> typQuery = entityManager.createQuery(query, CustomEmployee.class);
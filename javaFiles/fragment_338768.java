Query query = pm.newQuery(Employee.class);
query.setFilter("lastName == lastNameParam");
query.setOrdering("hireDate desc");
query.declareParameters("String lastNameParam");

try {
    List<Employee> results = (List<Employee>) query.execute("Smith");
    if (results.iterator().hasNext()) {
        for (Employee e : results) {
            // ...
        }
    } else {
        // ... no results ...
    }
} finally {
    query.closeAll();
}
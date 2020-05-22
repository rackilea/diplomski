List<Employee> employees = // ...
Collection<Employee> filtered = 
    Collections2.filter(employees, new Predicate<Employee>() {
        @Override
        public boolean apply(Employee e) {
            return e.getName().equals("John Doe");
        }
    });
// if you want a List:
List<Employee> filteredList = new ArrayList<>(filtered);
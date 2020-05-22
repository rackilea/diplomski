final Predicate<Employee> employeePredicate = 
    predicates.stream().reduce(Predicate::and).get();

// OR adult male
// Note that the result is saved back to employeePredicate
employeePredicate = employeePredicate.or(EmployeePredicates.isAdultMale());
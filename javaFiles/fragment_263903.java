private Supplier<Collection<Person>> cache = Suppliers.memoizeWithExpiration(
        new Supplier<Collection<Employee>>() {
            public Collection<Employee> get() {
                return getAllEmployees();
            }
        }, 1, TimeUnit.DAYS);

public Collection<Employee> getAllEmployees() {
    return cache.get();
}
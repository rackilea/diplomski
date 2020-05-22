public Employee(int id, String name, int salary, int age, Date dateOfJoining){
    this.id = id;
    this.name = Objects.requireNonNull(name);
    if (salary <= 0) {
        throw new IllegalArgumentException(
            "The salary should be positive, but is "+salary);
    }
    this.salary = salary;
    if (age <= 0) {
        throw new IllegalArgumentException(
            "The age should be positive, but is "+salary);
    }
    this.age = age;
    this.dateOfJoining = Objects.requireNonNull(dateOfJoining);
}
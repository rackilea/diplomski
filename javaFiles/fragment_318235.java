public Adminstrator() {
    super();
    this.salary = 0;
}

public Administrator(String name, String username, String password, double salary) {
    super(name, username, password);
    this.salary = salary;
}

public Adminstrator(Administrator original) {
    super(original);
    this.salary = salary;
}
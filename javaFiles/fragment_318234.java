public Administrator() {
    this.name = "";
    this.username = "";
    this.password = "";
    this.salary= 0;

}
public Admin(String name, String username, String password, double salary) {
    this.name = name;   
    this.username = username;
    this.password = password;
  this.salary = salary;

}
public Admin(Admin original) {
    super(original);
    this.name = original.name;
    this.username = original.username;
    this.salary = original.salary;
    this.salary = original.salary;
}


// person

 public Person() {
    this.name = "";
    this.username = "";
    this.password = "";
}

public Osoba( String name, String username, String password) {
    this.name = name;
    this.username = username;
    this.password = password;
}

public Person(Person original) {
    this.name = original.name;
    this.username = original.username;
    this.password = original.password;
}
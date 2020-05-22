// ...
private Date created = new Date();

public Student() {          
}

public Student(String firstName, String lastName, String address, String departmentName){
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.enrolledDepartment = departmentName;
    //this.created = new Date();
}
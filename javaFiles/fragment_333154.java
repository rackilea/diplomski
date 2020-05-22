public Teacher(String name, int age, String gender, String subject, int salary) {
    super(name, age, gender);
    //Constructor
    salary = salary;
    subject = subject;
    public String toString(){

    return super.toString() +", Subject: " + subject + " Salary: " + salary;
}
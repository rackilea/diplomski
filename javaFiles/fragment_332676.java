class Person {
    private String name;
    private int dob;
    private String gender;

    public Person(String theName, int birth, String sex) {
        name = theName;
        dob = birth;
        gender = sex;
    }

    public void getWorkDetail() {
        System.out.println("This person is not an Employee");
    }
}

class Employee extends Person {

    String department;
    double salary;

    public Employee(String theName, int birth, String sex) {
        super(theName, birth, sex);
        department = "Not assigned";
        salary = 30000;
    }

    public void getWorkDetail() {
        System.out.println("This person is an Employee");
    }
}
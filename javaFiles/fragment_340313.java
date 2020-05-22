public class Test {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("John Wick");
        s1.setId(1);
        s1.setYear("1st Year");
        s1.setDepartment(Department.CSE);

        Student s2 = new Student();
        s2.setName("Will Smith");
        s2.setId(2);
        s2.setYear("2nd Year");
        s2.setDepartment(Department.MEC);

        System.out.println(s1.getName() + " department is " + s1.getDepartment().getName());
        System.out.println(s2.getName() + " department is " + s2.getDepartment().getName());
    }
}
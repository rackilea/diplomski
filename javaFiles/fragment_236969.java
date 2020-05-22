public class ManipulateData {

public static void main(String[] args){
    Student student1 = new Student("James", 1, 500);
    List<Student> list = new ArrayList<Student>();
    list.add(student1);

    for(Student s: list){
        System.out.println("Name : " + s.getName());
        System.out.println("ID : " + s.getId());
        System.out.println("Balance : " + s.getBalanace());
    }
}
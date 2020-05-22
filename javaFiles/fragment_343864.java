import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class Student {

    String stud_id;
    String stud_name;
    String stud_location;

    public String getStud_id() {
        return stud_id;
    }

    public String getStud_name() {
        return stud_name;
    }

    public String getStud_location() {
        return stud_location;
    }



    Student(String sid, String sname, String slocation) {

        this.stud_id = sid;
        this.stud_name = sname;
        this.stud_location = slocation;

    }
}

class Temp
{
    public static void main(String args[])
    {

        Stream<Student> studs = 
        Stream.of(new Student("1726", "John", "New York"),
                new Student("4321", "Max", "California"),
                new Student("2234", "Max", "Los Angeles"),
                new Student("7765", "Sam", "California"));
        Map<String, Map<Object, List<Student>>> map= studs.collect(Collectors.groupingBy(Student::getStud_name,Collectors.groupingBy(Student::getStud_location)));
                System.out.println(map);//print by name and then location
    }

}
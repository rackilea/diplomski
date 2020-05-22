import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Function;


// Main attribute for lookup
enum Attribute {
    LASTNAME, GENDER
}

// subattribute for gender.  For lastname it would jut be a name.
// I decided to use an enum for gender.
enum Gender {
    M, F, O
};

public class CompositeSearch {
    // Map of map.
    // Example:
    //   Outer Map is for LastName attribute
    //   Inner map as all lists for common last names.  All names are included.
    //     I had to use an Object to allow for different types (enums, strings, ints)
    Map<Attribute, Map<Object, List<Student>>> studentsByAttribute = new HashMap<>();


    // this provides an extractor for each type requested. It just maps the 
    // Attribute to the Student Key method call for that type.
    Map<Attribute, Function<StudentKey, ?>> extractorsForType = new HashMap<>() {
        {
            put(Attribute.LASTNAME,
                    StudentKey::getLastName);
            put(Attribute.GENDER, StudentKey::getGender);
        }
    };

    // intiial data base
    TreeMap<StudentKey, Student> schoolsMap = new TreeMap<>();

    public static void main(String args[]) {
        new CompositeSearch().start();
    }

    public void start() {
        createSchoolsTreeMap();

        // getting all female students.
        List<Student> list = getStudentsForKeyAttribute(
                Attribute.GENDER, Gender.F);

        list.forEach(System.out::println);
        System.out.println();

        // getting all students with last name of holmes.
        list = getStudentsForKeyAttribute(Attribute.LASTNAME, "Holmes");
        list.forEach(System.out::println);

        // All maps for Gender and lastnames have been created so 
        // the lookups below require two map retrievals.  The attribute and the 
        // sub attribute
        System.out.println();
        list = getStudentsForKeyAttribute(
                Attribute.GENDER, Gender.M);

        list.forEach(System.out::println);
        System.out.println();

        list = getStudentsForKeyAttribute(Attribute.LASTNAME, "Watson");
        list.forEach(System.out::println);


    }

    public <T> List<Student> getStudentsForKeyAttribute(
            Attribute attr, T keyAttribute) {

        @SuppressWarnings("unchecked")
        Function<StudentKey, T> extractor = (Function<StudentKey, T>) extractorsForType
                .get(attr);

        if (!studentsByAttribute.containsKey(attr)) {
            // need to create the map.
            System.out.println("Building map for all " + attr);
            // sub attribute map
            Map<Object, List<Student>> subMap = new HashMap<>();

            studentsByAttribute.put(attr, subMap);

            for (Map.Entry<StudentKey, ?> e : schoolsMap
                    .entrySet()) {
              T subAttribute = extractor.apply(e.getKey());

                            subMap.compute(subAttribute,
                                    (k, v) -> v == null
                                            ?  new ArrayList<>()
                                            : v)
                            .add((Student)e.getValue());

            }
        } else {
            System.out.println("Using existing map for all " + attr);
        }
        return studentsByAttribute.get(attr).get(keyAttribute);

    }

    // from here on out, everything is pretty normal.
    private TreeMap<StudentKey, Student> createSchoolsTreeMap() {
        List<Student> students = List.of(
                new Student(1, "Sherlock", "Holmes",
                        Gender.M),
                new Student(2, "John", "Watson", Gender.M),
                new Student(3, "Franklin", "Holmes",
                        Gender.M),
                new Student(4, "Frances", "Holmes",
                        Gender.F),
                new Student(5, "Mary", "Wilson", Gender.F),
                new Student(6, "Martha", "Watson",
                        Gender.F));
        for (Student s : students) {
            schoolsMap.put(new StudentKey(s), s);
        }

        return schoolsMap;
    }

}

class StudentKey implements Comparable<StudentKey> {

    private int schoolId;
    private String lastname;
    private Gender gender;

    public StudentKey(Student student) {
        this.schoolId = student.getSchoolId();
        this.lastname = student.getLastname();
        this.gender = student.getGender();
    }

    public int getSchoolId() {
        return schoolId;
    }

    public String getLastName() {
        return lastname;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        StudentKey that = (StudentKey) o;
        return schoolId == that.schoolId
                && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolId, lastname);
    }

    @Override
    public int compareTo(StudentKey o) {
        return (this.schoolId + this.lastname)
                .compareTo(o.schoolId + o.lastname);
    }

}

class Student {

    int schoolId;
    String firstname;
    String lastname;
    Gender gender;

    public Student(int schoolId, String firstname,
            String lastname, Gender gender) {
        this.schoolId = schoolId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Student{" + "schoolId=" + schoolId
                + ", firstname='" + firstname + '\''
                + ", lastname='" + lastname + '\'' + '}';
    }
}
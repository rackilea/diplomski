enum Gender {

    Boy, Girl, Other;
}

enum Course {

    IT, CS;
}

class Student {

    final String name;
    final int age;
    final Gender gender;
    Course course;

    public Student(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return name + "\t" + age + "\t" + gender + "\t" + course + "\n";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        return true;
    }

}

public void test() {
    System.out.println("Hello");
    List<Student> students = Arrays.asList(
            new Student("A", 9, Gender.Boy),
            new Student("B", 10, Gender.Boy),
            new Student("B", 9, Gender.Boy),
            new Student("A", 9, Gender.Boy),
            new Student("A", 9, Gender.Girl)
    );
    // Fold it into a Set to eliminate duplicates.
    Set all = new HashSet();
    all.addAll(students);
    // Pull back out into a List.
    System.out.println("Students:\n" + all);
}
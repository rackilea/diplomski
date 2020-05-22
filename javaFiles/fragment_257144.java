public class StudentDemo {
    public static void main(String[] args) {

        Student st1 = new Student(1, "abhi", 200.5);
        Student st2 = new Student(2, "maggie", 200);
        Student st3 = new Student(3, "suraj", 107);
        Student st4 = new Student(4, "naveen", 249);
        Student st5 = new Student(5, "jajan", 101);

        Student[] sts = { st1, st2, st3, st4, st5 };
        System.out.println("splitStudentArray : " + java.util.Arrays.toString(splitStudentArray(sts, 'o')));
    }

    private static Student[] splitStudentArray(Student[] sts, char ch) {
        if (ch == 'o') {
            System.out.println("number is odd");
            return oddArray(sts); // create function or insert for loop here
        } else if (ch == 'e') {
            System.out.println("number is even");
            return evenArray(sts); // create function or insert for loop here
        } else {
            return null;
        }
    }

    private static Student[] oddArray(Student[] sts) {
        java.util.List<Student> list = new java.util.ArrayList<Student>();
        for (Student student : sts) {
            if (student.getMarks() % 2 != 0) {
                list.add(student);
            }
        }
        return list.toArray(new Student[0]);
    }

    private static Student[] evenArray(Student[] sts) {
        java.util.List<Student> list = new java.util.ArrayList<Student>();
        for (Student student : sts) {
            if (student.getMarks() % 2 == 0) {
                list.add(student);
            }
        }
        return list.toArray(new Student[0]);
    }

    private static class Student {
        private int rollNo;
        private String Name;
        private double Marks;

        public Student(int rollNo, String name, double marks) {

            this.rollNo = rollNo;
            this.Name = name;
            this.Marks = marks;
        }

        public int getRollNo() {
            return rollNo;
        }

        public void setRollNo(int rollNo) {
            this.rollNo = rollNo;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public double getMarks() {
            return Marks;
        }

        public void setMarks(double marks) {
            Marks = marks;
        }

        @Override
        public String toString() {
            return "Student [rollNo=" + rollNo + ", Name=" + Name + ", Marks=" + Marks + "]";
        }       

    }
}
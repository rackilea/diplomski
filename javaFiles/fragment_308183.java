import java.util.Arrays;

public class SortObject {

    public static void main(String args[]) {

        Student[] students = new Student[4];

        Student one = new Student(8.0, 1.8);
        Student two = new Student(2.0, 2.8);
        Student three = new Student(5.0, 1.1);
        Student four = new Student(1.0, 2.1);

        students[0] = one;
        students[1] = two;
        students[2] = three;
        students[3] = four;

        // Arrays.sort(students, Student.StudentComparator); // to sort on basis
        // of both rank and dist

        Arrays.sort(students);

        int i = 0;
        for (Student temp : students) {
            System.out.println("fruits " + ++i + " : " + temp.getRank()
                    + ", Quantity : " + temp.getDist());
        }

    }
}
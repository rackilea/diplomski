import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TopScores {

    private static final int TOP_SELECTION_SIZE = 2;

    public static class Student {
        private final String name;
        private double score;

        public Student(String name) {
            if (name == null || name.length() == 0) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public double getScore() {
            return score;
        }

        public void setScore(String score) {
            try {
                this.score = Double.parseDouble(score);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Illegal score: " + score);
            }
        }

        @Override
        public String toString() {
            return String.format("%s with score %s", name, score);
        }
    }

    public static void main(String[] args) {

        List<Student> students = new ArrayList<TopScores.Student>();
        System.out.println("Please enter students. Press <RETURN> to stop.");
        Scanner input = new Scanner(System.in);
        boolean enteringData = true;
        while (enteringData) {
            try {
                System.out.print("Enter student's name: ");
                Student student = new Student(input.nextLine());
                System.out.print("Enter student's score: ");
                student.setScore(input.nextLine());
                for (int i = 0; i < students.size(); i++) {
                    if (student.getScore() > students.get(i).getScore()) {
                        students.add(i, student);
                        break;
                    }
                }
                if (students.size() == 0) {
                    students.add(student);
                }
            } catch (IllegalArgumentException e) {
                enteringData = false;
            }
        }

        int studentsToDisplay = Math.min(TOP_SELECTION_SIZE, students.size());
        if (studentsToDisplay > 0) {
            System.out.println("Top students:");
            for (int i = 0; i < studentsToDisplay; i++) {
                System.out.println("* " + students.get(i));
            }
        } else {
            System.out.println("No students to display");
        }
    }
}
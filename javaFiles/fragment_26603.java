/**
 * StudentFactory
 * Created by Michael
 * Creation date 4/5/2016.
 * @link https://stackoverflow.com/questions/36439416/how-to-read-objects-from-an-input-file-and-write-to-an-output-file
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StudentFactory {

    public List<Student> getStudentList(Scanner scanner) {
        List<Student> studentList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (StudentFactory.isNotBlank(line)) {
                String [] tokens = line.split("\\s+");
                studentList.add(new Student(tokens[0], tokens[1], tokens[2], Double.parseDouble(tokens[3]), Integer.parseInt(tokens[4])));
            }
        }
        return studentList;
    }

    public Optional<Student> getBestStudent(List<Student> studentList) {
        return studentList.stream().max(Comparator.comparing(Student::getGpa));
    }

    public long countHonors(List<Student> studentList) {
        return studentList.stream().filter(Student::isHonors).count();
    }

    public static boolean isNotBlank(String s) {
        return (s != null) && !"".equals(s.trim());
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scan {

    public static void main(String[] args) {
        String fileName = "text.txt";
        List<Name> names = new ArrayList<>();

        try (Scanner scan = new Scanner(new File(fileName))) {
            while (scan.hasNext())
                names.add(new Name(scan.nextLine().replace(",", "")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(names);
    }

    public static class Name {
        private final String studentName;

        public Name(String studentName) {
            this.studentName = studentName;
        }

        public String getstudentName() {
            return studentName;
        }

        @Override
        public String toString() {
            return studentName;
        }
    }
}
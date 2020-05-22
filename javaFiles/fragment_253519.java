import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

public static final String CSV_PATH = "unsortedList.csv";
public static boolean append = true;
public static ArrayList<String> aList = new ArrayList<String>();

public static void main(String[] args) throws IOException {

    readAllLinesFromFile(CSV_PATH);
    System.out.println("Unsorted:\n");
    for(String aStudentString: aList){
        System.out.println(aStudentString +"\n");
    }

    ArrayList<Student> students = convertToStudents(aList);
    System.out.println("SORTED:\n");
    for(Student student : students){
        System.out.println(student.toString());
    }
}

public static ArrayList<String> readAllLinesFromFile(String path) throws IOException{

    FileReader fileReader = new FileReader(path);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    String line = null;
    while( (line = bufferedReader.readLine()) != null){
        aList.add(line);
    }
    bufferedReader.close();

    return aList;

}

public static ArrayList<Student> convertToStudents(ArrayList<String> studentsStrings) {
    ArrayList<Student> students = new ArrayList<>();
    studentsStrings.remove(0);
    for(String studentString : studentsStrings) {
        String[] parts = studentString.split(",");
        int studentID = Integer.valueOf(parts[0]);
        String fName = parts[1];
        String lName = parts[2];
        int mark = Integer.valueOf(parts[3]);
        String grade = parts[4];
        students.add(new Student(studentID, fName, lName, mark, grade));
    }

    Collections.sort(students, new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.compareTo(o2);
        } 
    });
    return students;
}
public static void writeAllLinesToFile(String path, ArrayList<String> aList) throws IOException {
    //ArrayList<String> aList = new ArrayList<String>();
    FileWriter fileWriter = new FileWriter(path, append);
    PrintWriter printWriter = new PrintWriter(fileWriter);
    for (String line : aList){
        printWriter.printf("%s" + "%n", line);
    }
    printWriter.close();
}
}
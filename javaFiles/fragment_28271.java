import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class reading_a_file {

  static void pull_info(String courseCode) throws IOException {

    BufferedReader read = new BufferedReader(new FileReader("CourseSample.txt"));

    Map<String, String> course_info = new HashMap<String, String>();

    String line;
    String[] data;

    while ((line = read.readLine()) != null) {
      data = line.split(" ");
      String courseID = data[0];
      String courseName = line.substring(line.indexOf(" ")+1);

      course_info.put(courseID, courseName);
      if (courseCode.equalsIgnoreCase(courseID)) {
        System.out.println(courseName);
      }
    }

  }

  public static void main(String[] args) throws IOException {

    Scanner console = new Scanner(System.in);
    String course_code;

    System.out.println("--------------------------------------------------");
    System.out.println("Welcome to text file formatter by XM21");
    System.out.println("--------------------------------------------------");
    System.out.println();
    System.out.println("Please enter course id to see description (-1 to exit):");
    System.out.println("CourseCode:");
    course_code = console.nextLine();

    pull_info(course_code);
    console.close();

  }
}
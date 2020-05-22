/**
 * JUnit test for StudentFactory
 * Created by Michael
 * Creation date 4/5/2016.
 * @link https://stackoverflow.com/questions/36439416/how-to-read-objects-from-an-input-file-and-write-to-an-output-file
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class StudentFactoryTest {

    private StudentFactory studentFactory = new StudentFactory();
    private List<Student> studentList;

    @Before
    public void setUp() throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File("./src/test/resources/input.txt"));
        this.studentFactory = new StudentFactory();
        this.studentList = studentFactory.getStudentList(fileScan);
    }

    @Test
    public void testGetStudentList() throws FileNotFoundException {
        Assert.assertEquals(8, studentList.size());
    }

    @Test
    public void testGetBestStudent() {
        String expected = "Optional[Student{lastName='Cool', firstName='Annie', id='0007', gpa=4.0, year=2013}]";
        Assert.assertEquals(expected, this.studentFactory.getBestStudent(this.studentList).toString());
    }

    @Test
    public void testCountHonors() {
        Assert.assertEquals(2L, this.studentFactory.countHonors(this.studentList));
    }

    public void printOutput(String outputFileName) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(outputFileName))) {
            pw.println(this.studentList);
            pw.println("best student: " + studentFactory.getBestStudent(studentList));
            pw.println("# of honors students: " + studentFactory.countHonors(studentList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
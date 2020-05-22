import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Philip Skogsberg
 */
public class ProcessStudents {

    Students la = new LAStudents();
    TechStudents tech = new TechStudents();
    StudentsIterator laItr = la.createIterator();
    StudentsIterator techItr = tech.createIterator();

    public void readAll() throws IOException {
        la.read();
        tech.read();
    }

    public void print() {
        ArrayList<StudentData> printList = new ArrayList();
        while (laItr.hasNext() && techItr.hasNext()) {
            StudentData laStudent = (StudentData) laItr.next();
            StudentData techStudent = (StudentData) techItr.next();
            printList.add(laStudent);
            printList.add(techStudent);
            if (laItr.isLast() || techItr.isLast()) {
                Collections.sort(printList);
                for (StudentData s : printList) 
                    System.out.println(s);
            }
        }
    }
}
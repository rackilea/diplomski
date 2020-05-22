import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "EmpObject.ser";

        ArrayList<Employee> empList = new ArrayList<>();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));

        empList.add(emp1);
        empList.add(emp2);
        oos.writeObject(empList);

        empList.add(emp3);
        // Create a new FileOutputStream to override the files content instead of appending the new employee list
        oos = new ObjectOutputStream( new FileOutputStream(path));
        oos.writeObject(empList);

        ObjectInputStream objectinputstream = new ObjectInputStream(new FileInputStream(path));
        List<Employee> readCase = (List<Employee>) objectinputstream.readObject();

        System.out.println(readCase);
    }
}
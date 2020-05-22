import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test
{
    public static void main(String args[]) throws Exception
    {
        Student s1 = new Student(211, "ravi");

        FileOutputStream fout = new FileOutputStream("f.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);

        out.writeObject(s1);
        out.flush();
        System.out.println("success");

        FileInputStream fis = new FileInputStream("f.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s1 = (Student)ois.readObject();
        System.out.println(s1);
    }
}
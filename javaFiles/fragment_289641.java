import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Testing implements Serializable {

private static final long serialVersionUID = 1L;

public static void main(String args[]) {
    Testing t = new Testing();
    String fileName = new String("copy.ser");
    t.write(t, fileName);
}

public void write(Testing t, String fileName) {

    try {

        FileOutputStream fout = new FileOutputStream("copy.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(t);
        oos.close();
        System.out.println("Done");

    } catch (Exception ex) {
        System.out.println(
            "Error writing to file '"
            + fileName + "'");
    }
}
}
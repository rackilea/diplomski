import java.util.ArrayList;
import java.io.*;

public class ListSerExample {
    public static void main(String[] args) {
        ArrayList<String> lst = new ArrayList<>();
        lst.add("a");
        lst.add("b");
        lst.add("c");


        try (FileOutputStream fos = new FileOutputStream("foo.dat"); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(lst);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> deserialized= new ArrayList<>();

        try (FileInputStream fis = new FileInputStream("foo.dat");
             ObjectInputStream ois = new ObjectInputStream(fis);){
            deserialized = (ArrayList) ois.readObject();
            ois.close();
            fis.close();

            System.out.println("deserialized = " + deserialized);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
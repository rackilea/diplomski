public static Person load(File saved_file) {
    try (FileInputStream load = new FileInputStream(saved_file);
         ObjectInputStream in = new ObjectInputStream(load)) {
        return (Person) in.readObject();
     } catch (...) { ... }
 }

public class Dummy {
    public static void main(String args[]) {
        Person father = Person.load(saved_file);
    }
}
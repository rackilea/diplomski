import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Shelf extends HashMap<String, Object> {
    private static final long serialVersionUID = 7127639025670585367L;
    private final File file;

    public static Shelf open(File file) {
    Shelf shelf = null;
    try {
        if (file.exists()) {
        final FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        shelf = (Shelf) ois.readObject();
        ois.close();
        fis.close();
        } else {
        shelf = new Shelf(file);
        shelf.sync();
        }
    } catch (Exception e) {
        // TODO: handle errors
    }
    return shelf;
    }

    // Shelf objects can only be created or opened by the Shelf.open method
    private Shelf(File file) {
    this.file = file;
    sync();
    }

    public void sync() {
    try {
        final FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
        fos.close();
    } catch (Exception e) {
        // TODO: handle errors
    }
    }

    // Simple Test Case
    public static void main(String[] args) {
    Shelf shelf = Shelf.open(new File("test.obj"));
    if (shelf.containsKey("test")) {
        System.out.println(shelf.get("test"));
    } else {
        System.out.println("Creating test string.  Run the program again.");
        shelf.put("test", "Hello Shelf!");
        shelf.sync();
    }
    }
}
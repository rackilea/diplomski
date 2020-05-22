import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws Exception {
        write();
    }

    static void write() throws Exception {
        Supplier<Thread> supplier = (Supplier<Thread> & Serializable)() -> new Thread() {};
        new ObjectOutputStream(System.out).writeObject(supplier);
    }
}
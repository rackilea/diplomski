import java.io.*;

class ClassSingleton implements Serializable {
    public static final ClassSingleton INSTANCE = new ClassSingleton();

    private ClassSingleton() {}
}

enum EnumSingleton {
    INSTANCE;
}

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        byte[] data;
        try (ByteArrayOutputStream output = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(output)) {
            oos.writeObject(ClassSingleton.INSTANCE);
            oos.writeObject(EnumSingleton.INSTANCE);
            data = output.toByteArray();
        }

        try (ByteArrayInputStream input = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(input)) {
            ClassSingleton first = (ClassSingleton) ois.readObject();
            EnumSingleton second = (EnumSingleton) ois.readObject();

            System.out.println(first == ClassSingleton.INSTANCE);
            System.out.println(second == EnumSingleton.INSTANCE);
        }
    }
}
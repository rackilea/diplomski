import java.io.*;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) throws Exception {
        var file = Path.of(System.getProperty("user.dir")).resolve("myenum.bin");
        switch (args[0].toLowerCase()) {
            case "save":
                var instance = MyEnum.INSTANCE;
                instance.setValue(10);
                try (var oos = new ObjectOutputStream(Files.newOutputStream(file))) {
                    oos.writeObject(instance);
                }
                break;
            case "load":
                try (var ois = new ObjectInputStream(Files.newInputStream(file))) {
                    System.out.println(((MyEnum) ois.readObject()).getValue());
                }
                break;
            default:
                throw new IllegalArgumentException("expected 'save' or 'load', actual = " + args[0]);
        }
    }

    public enum MyEnum {
        INSTANCE {
            private int value = 5;
            @Override public void setValue(int value) { this.value = value; }
            @Override public int getValue() { return value; }
        };
        public abstract void setValue(int value);
        public abstract int getValue();
    }
}
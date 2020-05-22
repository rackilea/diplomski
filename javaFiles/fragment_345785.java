import java.util.EnumMap;

enum Foo {}

public class Test {    
    public static void main(String[] args) {
        EnumMap<Foo, String> map = new EnumMap<Foo, String>(Foo.class);
    }
}
import java.util.HashMap;
import java.util.Map;

class Dog {
    public String name;

    public Dog(String n) {
        this.name = n;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class MapTest {
    public static void main(String ar[]) {
        Map<String, Object> m = new HashMap<String, Object>();
        Dog d1 = new Dog("clover");
        Dog d2 = new Dog("abcdef");
        m.put(d1.name, new Dog("aiko1"));
        m.put(d2.name, new Dog("aiko"));
        System.out.println(m.get(d1.name));
        System.out.println(m.get(d2.name));
    }
}
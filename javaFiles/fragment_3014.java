import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Test {
public static void main(String[] args) {
    List<? extends MyBean> input = new ArrayList<>();

    Map<MyKey, List<? extends MyBean>> output;
    output = test(input, MyKey.class); // doesn't compile
}

public static <K, E> Map<K, List<? extends E>> test(
        Collection<? extends E> a, Class<K> b) {
    return null;
}

private static class MyKey {
}

private static class MyBean {
}
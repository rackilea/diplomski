import java.util.Arrays;
import java.util.List;

class RealyCompilesAndRunsFine {

    public static String f(List<String> list) {
        return list.get(0);
    }

    public static Integer f(List<Integer> list) {
        return list.get(0);
    }

    public static void main(String[] args) {
        final String string = f(Arrays.asList("asdf"));
        final Integer integer = f(Arrays.asList(123));
        System.out.println(string);
        System.out.println(integer);
    }

}
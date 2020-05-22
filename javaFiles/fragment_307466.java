import java.util.stream.Stream;

public class TestSplit {
    public static void main (String... args) {
        Map<String, TestClass> map = split("2014@2@200@0#2014@2@200@0#2012@1@100@0#2012@3@200@0#2011@2@200@0");
        map.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    private static Map<String, TestClass> split(String input) {
        String[] testClassStrings = input.split("#");
        Stream<String[]> testClassStringsStream = Arrays.stream(testClassStrings).map(s -> s.split("@"));
        Stream<TestClass> testClasses = testClassStringsStream.map(s -> new TestClass(s[0], s[1], s[2], s[3]));
        Map<String, TestClass> testClassesMap = new HashMap<>();
        testClasses.forEach((TestClass tc) -> {
            TestClass oldValue = testClassesMap.get(tc.a0);
            testClassesMap.put(tc.a0, oldValue == null ? tc : new TestClass(oldValue, tc));
        });

        return testClassesMap;
    }
}
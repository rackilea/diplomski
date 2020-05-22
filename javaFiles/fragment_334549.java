public class Test {

    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();

        strings.add("111");
        strings.add("113");
        strings.add("112");
        strings.add("114");

        String contactString = strings.stream().map(String::toString).collect(Collectors.joining(","));
    }

}
Try this :
public class Test {

        public static void main(String[] args) {
            List<String> lineList = Arrays.asList("This is a test line");
            String lineString;
            lineString = lineList.stream().map(Object::toString)
                    .collect(Collectors.joining(", "));
            System.out.println(lineString);
    }

}
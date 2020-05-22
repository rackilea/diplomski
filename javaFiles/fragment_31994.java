import java.util.Date;

import org.codehaus.jackson.map.ObjectMapper;

public class Teste {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        printAsJs(null);
        printAsJs(5L);
        printAsJs("Hello!");
        printAsJs(new Date());
    }

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void printAsJs(Object o) throws Exception {
        System.out.println(OBJECT_MAPPER.writeValueAsString(o));
    }

}
import org.junit.Test;

public class AsciiTesting {

    @Test
    public void parse() {
        final String myString = "ćabc123ć";
        System.out.println(myString.replaceAll("ć", "&#263;"));
        // Then wrap the <tag> content with <![CDATA[ put your replaced string here ]]>
    }

}
import org.apache.commons.lang3.StringEscapeUtils;

public class LineSeparators {
    public static void main(String[] args) {
        String ls1 = StringEscapeUtils.escapeJava(System.getProperty("line.separator"));
        System.out.println("LineSeperator1: "+ls1);
        String ls2 = StringEscapeUtils.escapeJava(System.lineSeparator());
        System.out.println("LineSeperator2: "+ls2);
    }
}
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;

public class Test extends WinAnsiEncoding {

    public static String remove(String test) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < test.length(); i++) {
            if (WinAnsiEncoding.INSTANCE.contains(test.charAt(i))) {
                b.append(test.charAt(i));
            }
        }
        return b.toString();
    }

    public static void main(String[] args) {
        System.out.println(remove("abc\rcde"));
        // prints abccde
    }

}
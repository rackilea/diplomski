public class Foo {

    public static void main(String[] args)
    {
        String unicodeValue = "\u001B";
        String escapedUnicodevalue = "\\\\u001B";
        String text = "invalid" + unicodeValue + "string";

        text = text.replaceAll(unicodeValue, escapedUnicodevalue);

        System.out.println(text);
    }
}
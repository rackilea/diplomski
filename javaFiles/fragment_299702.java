public class Parser {

    public static final String ELEMENT_DELIM_REGEX = "\\|";

    public static void main(String[] args) {
        String input = "A|1|2|3^4|";
        String[] tokens = input.split(ELEMENT_DELIM_REGEX);
        Element[] elements = new Element[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            elements[i] = new Element(i + 1, tokens[i]);
        }
        for (Element element : elements) {
            System.out.println(element);
        }
    }

}
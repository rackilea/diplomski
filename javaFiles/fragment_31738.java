public class Parser {

    public static final String ELEMENT_DELIM_REGEX = "\\|";

    public static void main(String[] args) {
        String input = "A|1|2|3^4|B||1|2|3^4^5";
        String[] tokens = input.split(ELEMENT_DELIM_REGEX);
        List<Element> elements = new ArrayList<Element>();
        String currentTag = "";
        int elementCounter = 1;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].matches("\\p{Alpha}+")) {
                currentTag = tokens[i];
                elementCounter = 1;
                continue;
            }
            elements.add(new Element(elementCounter++, currentTag,  tokens[i]));
        }
        for (Element element : elements) {
            System.out.println(element);
        }
    }
}
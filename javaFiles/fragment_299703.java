public class Element {

    public static final String SUB_ELEMENT_DELIM_REGEX = "\\^";

    private int number;

    private String[] content;

    public Element(int number, String content) {
        this.number = number;
        this.content = content.split(SUB_ELEMENT_DELIM_REGEX);
    }

    @Override
    public String toString() {
        if (content.length == 1) {
            return "Element " + number + "\t" + content[0];
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < content.length; i++) {
            str.append("Element " + number + "." + (i+1) + "\t" + content[i] + "\n");   
        }
        // Delete the last \n
        str.replace(str.length() - 1, str.length(), "");
        return str.toString();
    }
}
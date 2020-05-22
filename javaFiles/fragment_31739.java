public class Element {

    public static final String SUB_ELEMENT_DELIM_REGEX = "\\^";

    private int number;

    private String[] content;

    private String tag;

    public Element(int number, String tag, String content) {
        this.number = number;
        this.content = content.split(SUB_ELEMENT_DELIM_REGEX);
        this.tag = tag;
    }

    @Override
    public String toString() {
        if (content.length == 1) {
            return tag + "" + number + "\t" + content[0];
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < content.length; i++) {
            str.append(tag + "" + number + "." + (i+1) + "\t" + content[i] + "\n");   
        }
        // Delete the last \n
        str.replace(str.length() - 1, str.length(), "");
        return str.toString();
    } 
}
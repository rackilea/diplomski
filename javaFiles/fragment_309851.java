import org.apache.commons.lang3.StringEscapeUtils;

public class HTMLCharacterEscaper {
    public static void main(String[] args) {        
        //With StringEscapeUtils
        System.out.println("Using SEU: " + StringEscapeUtils.escapeHtml4("\" ¶"));
        System.out.println("Using SEU: " + StringEscapeUtils.escapeXml11("'"));

        //Single quote & double quote
        System.out.println(escapeHTML("It's good"));
        System.out.println(escapeHTML("\" Grit \""));

        //Unicode characters
        System.out.println(escapeHTML("This is copyright symbol ©"));
        System.out.println(escapeHTML("Paragraph symbol ¶"));
        System.out.println(escapeHTML("This is pound £"));      
    }

    public static String escapeHTML(String s) {
        StringBuilder out = new StringBuilder(Math.max(16, s.length()));
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > 127 || c == '"' || c == '<' || c == '>' || c == '&' || c == '\'') {
                out.append("&#");
                out.append((int) c);
                out.append(';');
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }

}
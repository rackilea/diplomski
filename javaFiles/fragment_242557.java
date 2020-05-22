import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class StringParsing {

    private String[][] tokens = { {"Ax:", " "}, 
            {"Ay:", " "}, {"Az:", " "}, {"Tp:", " "}, {"B:", " "},
            {"Tm:", " Sº"} };

    public Properties parseString(String s) {
        Properties p = new Properties();

        for (int i = 0; i < tokens.length; i++) {
            String value = getValue(s, tokens[i][0], tokens[i][1]);
            p.setProperty(tokens[i][0], value);
        }
        return p;
    }

    private String getValue(String s, String token, String endToken) {
        int sPos = s.indexOf(token);
        if (sPos >= 0) {
            int ePos = s.indexOf(endToken, sPos + 1);
            if (ePos > sPos) {
                sPos += token.length();
                return s.substring(sPos, ePos);
            }
        }
        return "";
    }


    public static void main(String[] args) {
        String s = "c~ ¹\" M:0013A20040559361 Ax:48 Ay:10 Az:1012 " + 
                "Tp:25 B:45 ? Tm:Wednesday, 02/01/13 - 16:16.57 Sº~";

        StringParsing parsing = new StringParsing();
        Properties p = parsing.parseString(s);

        Set<Object> keys = p.keySet();
        Iterator<Object> iter = keys.iterator();

        while(iter.hasNext()) {
            String key = (String) iter.next();
            String value = p.getProperty(key);
            System.out.println(key + " " + value);
        }
    }

}
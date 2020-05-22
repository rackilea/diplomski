import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    private static ArrayList<TokenInfo> tokenInfoList = new ArrayList<>();
    private static ArrayList<String> tokensList = new ArrayList<>();

    public static void add(String regex, int token) {
        tokenInfoList.add(new TokenInfo(Pattern.compile(regex), token));
    }

    static {
        String LTHAN = "<[^>]*>";
        String LTHAN_SLASH = "</[^>]*>";
        String COMMENT = "<!--.*-->";
        add(LTHAN, 1);
        add(LTHAN_SLASH, 3);
        add(COMMENT, 5);
    }

    private static class TokenInfo {
        public final Pattern regex;
        public final int token;

        public TokenInfo(Pattern regex, int token) {
            super();
            this.regex = regex;
            this.token = token;
        }
    }

    public static void tokenize(String str) {
        String s = new String(str);
        while (!s.equals("")) {
            boolean match = false;
            for (TokenInfo info : tokenInfoList) {
                Matcher m = info.regex.matcher(s);
                if (m.find()) {
                    match = true;
                    String tok = m.group().trim();
                    tokensList.add(tok);
                    s = m.replaceFirst("");
                    break;
                }
            }
            // The following is under the assumption that the Text nodes within the document are not considered tokens and replaced
            if (!match) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader br;
            String curLine;
            String EOF = null;
            StringBuilder sb = new StringBuilder();

            try {
                File dir = new File("/home/itachi/Desktop/recipe.xml");
                br = new BufferedReader(new FileReader(dir));

                while ((curLine = br.readLine()) != EOF) {
                    sb.append(curLine);
                    // System.out.println(curLine);
                }
                br.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            tokenize(sb.toString());

            for (String eachToken : tokensList) {
               System.out.println(eachToken);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
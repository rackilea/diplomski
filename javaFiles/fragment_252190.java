import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regex {

    public Regex() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        String input = "Try a lot of match groups\r\n" + 
                "\r\n" + 
                "[COD_BODY=\"AZI_DIP-ANAG_AZI\", LABEL=\"Apri link1\"] come on Taranto\r\n" + 
                "\r\n" + 
                "[ COD_BODY=\"AZI_DIP-ANAG_AZI\", LABEL=\"Apri link2\"]\r\n" + 
                "\r\n" + 
                "[ COD_BODY =\"AZI_DIP-ANAG_AZI\", LABEL=\"Apri link3\"]\r\n" + 
                "\r\n" + 
                "[ COD_BODY = \"AZI_DIP-ANAG_AZI\", LABEL=\"Apri link4\"]\r\n" + 
                "\r\n" + 
                "[ COD_BODY = \"AZI_DIP-ANAG_AZI\", LABEL =\"Apri link5\"]\r\n" + 
                "\r\n" + 
                "[ COD_BODY = \"AZI_DIP-ANAG_AZI\", LABEL = \"Apri link6\"]\r\n" + 
                "\r\n" + 
                "[ COD_BODY = \"AZI_DIP-ANAG_AZI\" , LABEL = \"Apri link5\" ]";
        Pattern pattern = Pattern.compile("(\\[(\\s*)\\bCOD_BODY(\\s*)=(\\s*)\"(.*)?\"(\\s*),(\\s*)LABEL(\\s*)=(\\s*)\"(.*)?\"(\\s*)\\]*)");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }

}
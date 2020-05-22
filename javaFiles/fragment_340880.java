import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseInt {

    public static void main(String[] args) {
        String test =  "int a, b, c = 0, d;\n\nint e, b, c = 0, d";

        String pattern = "int(.*)";
        Pattern r = Pattern.compile(pattern);

        String patternVar = "([A-Za-z][a-zA-Z_0-9]*)(\\[\\])?";
        Pattern rVar = Pattern.compile(patternVar);

        String[] linesNewline = test.split("\n");

        for (int nLI=0;nLI < linesNewline.length; ++nLI) {
            String[] lines = linesNewline[nLI].split(";");
            for (int i=0;i < lines.length; ++i) {
                Matcher m = r.matcher(lines[i]);
                if (m.find()) {
                    String[] variables = m.group(1).split(",");
                    for (int ii=0; ii < variables.length; ++ii) {
                        Matcher mVar = rVar.matcher(variables[ii].trim());
                        if (mVar.find()) {
                            System.out.println("Variable is " + mVar.group(1));
                    }
                }
            }
        }
    }
  }
}
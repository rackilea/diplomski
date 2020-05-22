import java.util.regex.*;
public class TEST {
    // Set maximum size of array of filenames.
    public static final int MAX_NAMES = 100;
    // Get all filenames from PHP include variations and return in array.
    public static String[] getIncludes(String text)
    {
        int count = 0;                          // Count of filenames.
        String filenames[] = new String[MAX_NAMES];
        String filename;
        Pattern p = Pattern.compile(
            "# Match include variations with single string filename. \n" +
            "\\b             # Anchor to word boundary.              \n" +
            "(?:             # Group include variation alternatives. \n" +
            "  include       # Either 'include',                     \n" +
            "| require       # or 'require'.                         \n" +
            ")               # End group of include variation alts.  \n" +
            "(?:_once)?      # Either one may have '_once' suffix.   \n" +
            "\\s*            # Optional whitespace.                  \n" +
            "(?:             # Group for optional opening paren.     \n" +
            "  \\(           # Literal open parentheses,             \n" +
            "  \\s*          # followed by optional whitespace.      \n" +
            ")?              # Opening parentheses are optional.     \n" +
            "(?:             # Group for filename alternatives.      \n" +
            "  '([^']+)'     # $1: Either a single quoted filename,  \n" +
            "| \"([^\"]+)\"  # or $2: a double quoted filename.      \n" +
            ")               # End group of filename alternativess.  \n" +
            "(?:             # Group for optional closing paren.     \n" +
            "  \\s*          # Optional whitespace,                  \n" +
            "  \\)           # followed by the closing parentheses.  \n" +
            ")?              # Closing parentheses is optional .     \n" +
            "\\s*            # End statement with optional ws,       \n" +
            ";               # followed by a semi-colon.               ",
            Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.COMMENTS);
        Matcher m = p.matcher(text);
        while (m.find() && count < MAX_NAMES) {
            // The filename is in either $1 or $2
            if (m.group(1) != null) filename = m.group(1);
            else                    filename = m.group(2);
            // Add this filename to array of filenames.
            filenames[count++] = filename;
        }
        return filenames;
    }
    public static void main(String[] args)
    {
        // Test string full of various PHP include statements.
        String text = "<?php\n"+
            "\n"+
            "require('a.php');\n"+
            "require 'b.php';\n"+
            "require(\"c.php\");\n"+
            "require \"d.php\";\n"+
            "\n"+
            "include('e.php');\n"+
            "include 'f.php';\n"+
            "include(\"g.php\");\n"+
            "include \"h.php\";\n"+
            "\n"+
            "require_once('i.php');\n"+
            "require_once 'j.php';\n"+
            "require_once(\"k.php\");\n"+
            "require_once \"l.php\";\n"+
            "\n"+
            "include_once('m.php');\n"+
            "include_once 'n.php';\n"+
            "include_once(\"o.php\");\n"+
            "include_once \"p.php\";\n"+
            "\n"+
            "?>\n";
        String filenames[] = getIncludes(text);
        for (int i = 0; i < MAX_NAMES && filenames[i] != null; i++) {
            System.out.print(filenames[i] +"\n");
        }
    }
}
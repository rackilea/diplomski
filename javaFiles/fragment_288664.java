import java.util.regex.*;

public class test
{
    public static void main(String[] args)
    {
        String s =
        "CREATE UNIQUE INDEX index555 ON\nSOME_TABLE\n(\n    SOME_PK          ASC\n);\nCREATE UNIQUE INDEX index666 ON\nOTHER_TABLE\n(\n    OTHER_PK          ASC\n);\n";

        Pattern p = Pattern.compile("([^;]*?('.*?')?)*?;\\s*", Pattern.CASE_INSENSITIVE | Pattern.DOTALL | Pattern.MULTILINE);

        Matcher m = p.matcher(s);

        while (m.find())
        {
        System.out.println ("--- Statement ---");
        System.out.println (m.group ());
        }
    }
}
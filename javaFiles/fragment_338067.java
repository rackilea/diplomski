import java.util.regex.*;

class  FindModel
{
    public static void main(String[] args) 
    {
        String s = "  FooModel f = new FooModel();";
        String pattern = "([^\\s]*?Model[^=]*)=";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);

        if(m.find())
            System.out.print(m.group(1) + "\n");
     }
}
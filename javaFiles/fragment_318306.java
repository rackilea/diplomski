public class App2 {


private static final String PARA_STRING = "<Level type=\"Para\" id=\"%s\">\n\t%s";
private static final String SUBPARA_STRING = "\t<Level type=\"Sub-Para\" id=\"%s%s\">\n\t\t%s";
private static final String CLAUSE_STRING = "\t\t<Level type=\"Clause\" id=\"%s%s%s\">\n\t\t\t%s";

public static void main(String[] args) throws Exception
{
    StringBuilder input = new StringBuilder();
    input.append("(A) Preparations");
    input.append("\n");
    input.append("(1) Required ingredients to prepare...");
    input.append("\n");
    input.append("(a) 100ml of coconut oil");
    input.append("\n");
    input.append("(b) 2 table spoon of lemon mixed..");
    input.append("\n");
    input.append("(B) Process steps");
    input.append("\n");
    input.append("(i) Mix well the ...");
    input.append("\n");
    input.append("(ii) Apply in all parts of ...");
    input.append("\n");
    input.append("(iii) Gently give a massage..");
    input.append("\n");

    buildParagraphs(input.toString());
}

/**
 * 
 * @throws Exception
 */
public static void buildParagraphs(String input) throws Exception
{
    StringBuilder result = new StringBuilder();

    String[] inputArray = input.split("\n");
    String paraPrefix = null;
    String subParaPrefix = null;


    for (int i = 0; i < inputArray.length; i++)
    {
        String item = inputArray[i].split(" ")[0];
        if(isPara(item))
        {
            result.append(String.format(PARA_STRING, item, inputArray[i]));
            result.append("\t");
            result.append("\n");
            paraPrefix = item;
        }
        else if(isSubPara(item))
        {
            result.append(String.format(SUBPARA_STRING, paraPrefix, item, inputArray[i]));
            result.append("\t");
            result.append("\n");
            subParaPrefix = item;
        }
        else if(isClause(item))
        {
            result.append(String.format(CLAUSE_STRING, paraPrefix, subParaPrefix, item, inputArray[i]));
            result.append("\t\t");
            result.append("\n");
        }
    }

    System.out.println(result);
}

public static boolean isPara(String source)
{
    Pattern p = Pattern.compile("\\([A-Z]\\)");
    Matcher m = p.matcher(source);
    boolean b = m.matches();

    return b;
}

public static boolean isSubPara(String source)
{
    Pattern p = Pattern.compile("^\\([[0-9]|i]+\\)$");
    Matcher m = p.matcher(source);
    boolean b = m.matches();

    return b;
}

public static boolean isClause(String source)
{
    Pattern p = Pattern.compile("\\([a-z]\\)");
    Matcher m = p.matcher(source);
    boolean b = m.matches();

    return b;
}}
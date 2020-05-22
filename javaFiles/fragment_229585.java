import java.util.StringTokenizer;
class  WordsFromString
{
    public static void main(String st[])
    {
        String data = "Scanner Inlist 1,2,3\n"+
                      "Resolved scan set NotEqual to  Non Scan Set\n"+
                      "Area of intrest equal to Total Intrest\n"+
                      "Initial responder Inlist enter values";
        StringTokenizer tokenizer = new StringTokenizer(data,"\n",true);
        StringBuilder output = new StringBuilder();
        while (tokenizer.hasMoreElements())
        {
            String sLine = tokenizer.nextToken();
            StringTokenizer tokenizerWord = new StringTokenizer(sLine," ",true);
            while (tokenizerWord.hasMoreElements())
            {
                String word = tokenizerWord.nextToken();
                if ("Inlist".equals(word) || "NotEqual".equals(word) || "Inlist".equals(word) || "equal".equals(word))
                {
                    break;
                }
                else
                {
                    output.append(word);
                }
            }
        }
        System.out.println(output.toString());
    }

}
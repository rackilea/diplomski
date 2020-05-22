public class Happiness
{    
    public static void main(String[] args)
    {
        List<String> sentences = new ArrayList<String>(); //USE THE INTERFACE
        sentences.add("it would be for his happiness and having some feelings himself");
        sentences.add("a plan to promote the happiness of all she and Mr");
        sentences.add("a most unreasonable degree of happiness She must wait a moment");

        int maxHIndex = -1;
        for(String sentence : sentences) 
        {
            int hIndex = sentence.indexOf("happiness");
            if(hIndex > maxHIndex)
            {
                maxHIndex = hIndex;
            }
        }
        for(String sentence : sentences)
        {
            StringBuffer sb = new StringBuffer("");
            for(int i = 0; i < maxHIndex - sentence.indexOf("happiness") ; i++)
            {
                sb.append(" ");
            }
            System.out.println(sb.toString() + sentence);
        }
    }
}
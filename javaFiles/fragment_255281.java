import java.util.LinkedHashMap;
import java.util.Map;

public class ComputeIfPresentExample 
{
    public static void main(String[] args) 
    {
        Map<String, Integer> wordCounts = new LinkedHashMap<String, Integer>();

        String s = 
            "Lorem ipsum dolor sit amet consetetur iam nonumy sadipscing " + 
            "elitr, sed diam nonumy eirmod tempor invidunt ut erat sed " + 
            "labore et dolore magna dolor sit amet aliquyam erat sed diam";

        wordCounts.put("sed", 0);
        wordCounts.put("erat", 0);

        for (String t : s.split(" "))
        {
            wordCounts.computeIfPresent(t, (k,v) -> v+1);
        }
        System.out.println(wordCounts);
    }
}
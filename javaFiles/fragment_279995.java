import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SearchTextFile
{
    public static void main(String args[]) throws Exception
    {
        int tokencount;
        FileReader fr = new FileReader("c:\\searchtxt.txt");
        BufferedReader br = new BufferedReader(fr);

        String s = "";
        int linecount = 0;
        ArrayList<String> keywordList = new ArrayList<String>(Arrays.asList("AB", "BC", "D1", "B11", "BL:", "B/1:", "B1L:", "B11:"));

        String line;
        while ((s = br.readLine()) != null)
        {
            String[] lineWordList = s.split(" ");
            for (String word : lineWordList)
            {
                if (keywordList.contains(word))
                {
                    System.out.println(s);
                    String nextLine = br.readLine();
                    System.out.println(nextLine);
                    break;
                }
            }
        }
    }
}
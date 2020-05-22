import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringTokenizerDemo
{
    private static class WordItem
    {
        public int id;
        public String word;

        public WordItem(int id, String word)
        {
            this.id = id;
            this.word = word;
        }
    }

    public static void main(String[] args)
    {
        String text = "this is my text";
        List<WordItem> wordItems = makeWordItemsFromString(text);

        //Loop over them and print them out, or do whatever you like here
        for(WordItem wordItem : wordItems)
        {
            System.out.println(wordItem.word + "(" + wordItem.id + ")");
        }
    }

    private static List<WordItem> makeWordItemsFromString(String text)
    {
        int count = 1;
        List<WordItem> wordItems = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(text);
        while(tokenizer.hasMoreTokens())
        {
            wordItems.add(new WordItem(count++, tokenizer.nextToken()));
        }
        return wordItems;
    }
}
import java.util.Set;
import java.util.TreeSet;

public class Dictionary
{
    public static void main(String[] args)
    {
        Set<String> dictionary = new TreeSet<String>();
        dictionary.add("zebra");
        dictionary.add("wildebeast");
        dictionary.add("aardvark");
        System.out.println(dictionary); // will be in the correct alphabetical order.
    }
}
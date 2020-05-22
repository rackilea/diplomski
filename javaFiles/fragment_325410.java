import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class TestCheckWord2 {
    public static void main (String args[]){        
        System.out.println(checkWord("babo"));
        System.out.println(checkWord("bobo"));      
    }
    private static String[] WORDS =  {"admin", "babo", "melon", "sir", "administrator"};
    private static Set<String> mySet = new HashSet<String>(Arrays.asList(WORDS));
    public static boolean checkWord(String input) { 
        return mySet.contains(input);
    }   
}
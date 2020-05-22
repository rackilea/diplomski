import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        String answer = "answer";

        String[] answerArray = answer.split("");
        ArrayList<String> letters = new ArrayList<String>(Arrays.asList(answerArray));

        Collections.shuffle( letters );

        while (!letters.isEmpty())
        {
            String letter = letters.remove(0);
            System.out.println(letter);
        }
    }
}
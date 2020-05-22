import java.util.Scanner;

public class PigLatin {
    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );
        String yourSentence="";
        do {
            String[] words;
            System.out.print("Enter your words here: ");
            yourSentence = input.nextLine();
            words = yourSentence.split(" ");
            for (String word : words) {
                if (word.startsWith("a") || word.startsWith("e") || word.startsWith("i") || word.startsWith("o") || word.startsWith("u"))
                    System.out.print(word + "way ");
                else if (word.startsWith("sh") || word.startsWith("ch") || word.startsWith("th"))
                    System.out.print(word.substring(2)+word.substring(0,2)+"ay ");
                else
                    System.out.print(word.substring(1)+word.substring(0,1)+"ay ");
        }
        System.out.println();
        } while(!yourSentence.equals("quit"));
    }
}
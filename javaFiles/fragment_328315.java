import java.util.ArrayList;
public class StringDemo{

    public static void main(String... args){
        String S1 = "We love prefix  that have car strongly wheels and car  seats";
        String S2 = "I have a lovely designed car that has many beautifully predesigned car features and the car has a good prebuilt car";

        printWordsWithPre(S1);
        printWordsWithPre(S2);

        // These functions don't return any data so they can't be printed. The results are already printed in the function above.
        /*System.out.println(printWordsWithPre(S1));
        System.out.println(printWordsWithPre(S1));*/
    }
    // Tokenises a string/sentence and prints only the words that starts with pre.
    public static void printWordsWithPre(String str){
        String[] sTokens = str.split("\\p{javaWhitespace}");
        for(int i = 0; i < sTokens.length; i++){
            //check if it starts with rather than ends with
            if(sTokens[i].startsWith("pre")){
                System.out.println(sTokens[i]);
            }
        }
    }

}
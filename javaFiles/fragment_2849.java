import java.util.ArrayList;
import java.util.Scanner;

public class myTest{

    public static void main(String[] args) {
        String [] myWords = {"Finding", "string", "from", "word", "list", "with", "some", "characters", "from", "the", "string"};
        String [] myChars = new String[10];
        String match;
        boolean matches;
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> indexes = new ArrayList<>();

        System.out.println("Enter the string that has to match ");
        System.out.println("Enter '-' if it doesn't matter");
        match = scan.nextLine();
        for (int i = 0 ; i < 10 ; i++){
            myChars[i] = String.valueOf(match.charAt(i));
            if (!myChars[i].equals("-")) indexes.add(i);
        }


        for (int i = 0 ; i < myWords.length ; i++){
            matches = true;
            for (int j = 0 ; j < indexes.size() ; j++){
                if (!String.valueOf(myWords[i].charAt(indexes.get(j))).equals(myChars[indexes.get(j)])){
                    matches = false;
                    break;
                }
            }
            if (matches) System.out.println(myWords[i]);
        }
    }
}
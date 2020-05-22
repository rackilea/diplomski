import java.util.ArrayList;

public class Word {

    String wordName;
    ArrayList<Character> uniqueLetters;

    public Word(String wordName, ArrayList<Character> uniqueLetters) {
        this.wordName = wordName;
        this.uniqueLetters = uniqueLetters;
    }

    public Word(String string) {
        ArrayList<Character> tempArray = new ArrayList<Character>();

        for (int i = 0; i < string.length(); i++) { 
                        tempArray.add(string.charAt(i));
                    }

        this.wordName = string;
        this.uniqueLetters = tempArray;
    }

}
import java.util.ArrayList;
import java.util.HashMap;

public class TestDriver {

public static void main(String[] args) {    

    String text = "i like apples";  
    char[] textArray = text.toCharArray();

    //a dictionary that will hold the letter as the key and a list of it's positions as the value.
    HashMap<Character, ArrayList<Integer>> dictionary = new HashMap<Character, ArrayList<Integer>>();

    //loop through the text to check each letter
    for (int i = 0; i < textArray.length; i++) {            

        //if you've already checked this letter, skip to the next one
        if(dictionary.containsKey(textArray[i])) {
            continue;
        }       

        //add the letter's position to its position list
        ArrayList<Integer> positionList = new ArrayList<>();
        positionList.add(i);

        //compare the remaining letters in the text to the current letter
        for (int j = i+1; j < textArray.length; j++) {

                //if a letter matches, add it's position to the list
                if(textArray[i] == textArray[j]) {
                positionList.add(j);
            }   
        }               

        //add the letter and its list of positions to the dictionary
        dictionary.put(textArray[i], positionList);
    }

    //format the response
    for(char key : dictionary.keySet()) {
        ArrayList<Integer> positions = new ArrayList<>();
        positions = dictionary.get(key);
        System.out.println(key + " has an occurance of " + positions.size() + " on positions: " + positions);           
        }
    }
}
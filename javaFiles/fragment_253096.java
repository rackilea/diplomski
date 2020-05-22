import java.io.*;
import java.util.*;

public class LongestWord implements Comparator<String>{
    //compare function to be used for sorting the array according to word length
    public int compare(String s1, String s2) {
        if (s1.length() < s2.length())
           return 1;
    else if (s1.length() > s2.length())
        return -1;
    else
        return 0;
}

public static void main(String[] args){
    BufferedReader br = null;
    try{
        File file = new File(args[0]);
        br = new BufferedReader(new InputStreamReader(new     FileInputStream(file)));
        String line = null;
        //array for each word
        String[] words = new String[] {}; 
        while ((line = br.readLine()) != null){
            words = line.split("\\s+"); //splitting the string with spaces
        }

        //sort the array according to length of words in descending order
        Arrays.sort(words, new LongestWord());

        /* start with the longest word in the array and check if the other words are its substring.
         * If substring, then remove that part from the superstring.
         * Finally, if the superstring length is 0, then it is the longest word that can be formed.*/
        for (String superString: words) {
            String current = new String(superString); // to store a copy of the current superstring as we will remove parts of the actual superstring
            for (String subString: words) {
                if (!subString.equals(current) && superString.contains(subString)) { // superstring contains substring
                    superString = superString.replace(subString, "");  // remove the substring part from the superstring
                }
            }

            if (superString.length() == 0){
                System.out.println(current);
                break; // since the array is sorted, the first word that returns length 0  is the longest word formed
            }
        }
    }
    catch(FileNotFoundException fex){
        System.out.println("File not found");
        return;
    }
    catch(IOException e){
        e.printStackTrace();
    }
    finally{
        try {
            if (br != null){
                br.close();
            }
        } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
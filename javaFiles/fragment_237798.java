import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomizeData {

    public static void main(String[] args){
            ArrayList<String> fileData = new ArrayList<String>(); // arraylist is more dynamic 
            Scanner fileIN = null;
            PrintWriter out = null;

            try {
                fileIN = new Scanner(new File("C:\\Users\\Yahya\\Desktop\\SortedData.txt")); // for example
                out = new PrintWriter(new File("C:\\Users\\Yahya\\Desktop\\UnSortedData.txt")); // for example
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            while(fileIN.hasNext()){ // read the entire file of sorted data
                fileData.add(fileIN.nextLine());// add each line to the arraylist 
            }

            List<Integer> indexRef = new ArrayList<Integer>(); // create arraylist of integers to be as indices reference
               for(int i=0; i<fileData.size(); i++){
                      indexRef.add(i); // populate it
               }

            Random rnd = new Random();
            for(int i=0; i<fileData.size(); i++){ // for every index (line from the file)
                int rndIndex = indexRef.get(rnd.nextInt(indexRef.size())); // create random index
                out.println(fileData.get(rndIndex)); // get the data at that index in the arraylist 
                indexRef.remove(indexRef.indexOf(rndIndex)); // then remove the index from the indexRef arraylist in order not to use it again
            }
            out.close(); // close the printwriter          

        }           
}
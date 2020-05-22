import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main{

    public static void main(String[] args) throws FileNotFoundException, MalformedURLException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("Data.csv"));
        String line;
        String splitBy = ",";
        Set<String> dataFromDictionary = new HashSet<>(); 

        while((line = br.readLine()) != null){
             String[] b = line.split(splitBy);
             for(String s : b){
              dataFromDictionary.add(s.toLowerCase()); 
             }
        }
        br.close();

        URL book = new URL("http://manybooks.net/send/1:text:.txt:text/topeliusz2724927249-8/topeliusz2724927249-8.txt)");
        BufferedReader in = new BufferedReader(new InputStreamReader(book.openStream(),StandardCharsets.ISO_8859_1)); // added Charsets so that å, ä ... are correct encoded

        Set<String> dataFrombook = new HashSet<>();
        String inputLine;
        int lineNumber = 1;
        while ((inputLine = in.readLine()) != null){
            lineNumber++;

            if(lineNumber > 54 && lineNumber < 1313){   // just jumped the copyright stuff
                System.out.println(inputLine);
                String[] words = inputLine.split("[\\s\\p{Punct}]+"); // split the line at blank space or punctuations like . , ; ! etc. to get only the words
                for(String s : words){
                    if(s.matches("\\p{L}+")){     // check if the string contains only letters // not to add numbers to your dictionary                   
                        dataFrombook.add(s.toLowerCase());  // change all to lowercase or uppercase because otherwise "Apple" will be treated as different word as "apple"
                    }                    
                }
            }
        }
        in.close();

        String csvFile = "newData.csv"; // write to new file or overwrite Data.csv
        FileWriter writer = new FileWriter(csvFile);

        dataFromDictionary.addAll(dataFrombook);
        Set<String> sorted = new TreeSet<>(dataFromDictionary);
        for(String s : sorted){           
            writer.write(s);  
            writer.write("\n"); // no idea how your csv file is structured; this will write each word to a new line; modify if necessary
        }
        writer.flush();
        writer.close();
    }
}
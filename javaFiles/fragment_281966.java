import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class FileWordCounter {

    public static List<HashMap<String, Integer>> storeLoadedFiles()  {
        final File directory = new File("C:/Users/Admin/Desktop/dataFiles/"); 
        List<HashMap<String, Integer>> listOfWordCountMap = new ArrayList<HashMap<String, Integer>>(); 
        Scanner input = null;
        StringBuilder data; 
        try {
            for (final File fileEntry : directory.listFiles()) {
                input = new Scanner(fileEntry);
                input.useDelimiter("\t");
                data = new StringBuilder();
                while (input.hasNext()) { 
                    data.append(input.next());
                }
                input.close();
                String wordsInFile = data.toString().replaceAll("\\s+", " "); 
                HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>(); 

                for(String word : wordsInFile.split(" ")){
                    String strippedWord = word.toLowerCase().replaceAll("\\W", "");
                    int wordAppearCount = 0;
                    if(strippedWord.length() > 0){
                        if(wordCountMap.containsKey(strippedWord)){
                            wordAppearCount = wordCountMap.get(strippedWord);
                        }
                        wordCountMap.put(strippedWord, ++wordAppearCount);
                    }
                }
                listOfWordCountMap.add(wordCountMap);
            } 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(input != null) {
                input.close();
            }
        }
        return listOfWordCountMap; 
    }

    public static void loadAllHashmapWords(List<HashMap<String, Integer>> listOfWordCountMap) {
        for(HashMap<String, Integer> wordCountMap : listOfWordCountMap){
            for(Entry<String, Integer> wordCountEntry : wordCountMap.entrySet()){
                System.out.println(wordCountEntry.getKey() + " - " + wordCountEntry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        List<HashMap<String, Integer>> listOfWordCountMap = storeLoadedFiles();
        loadAllHashmapWords(listOfWordCountMap);
    }
}
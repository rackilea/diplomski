package forums;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordOccurrenceCount
{
  public static void main(String[] args) {
    try {
      String[] words = { "and", "is", "a", "the", "of", "as" };
      int[] occurrences = readOccurrences("C:/tmp/prose.txt", words);
      for ( int i=0; i<words.length; i++ ) {
        System.out.println(words[i] + " " + occurrences[i]);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static final int[] readOccurrences(String filename, String... words) 
    throws IOException
  {
    int[] occurrences = new int[words.length];
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(filename));
      Scanner scanner = new Scanner(reader);
      while ( scanner.hasNext() ) {
        String word = scanner.next();
        for ( int i=0; i<words.length; i++ ) {
          if ( words[i].equals(word) ) {
            occurrences[i]++;
          }
        }
      }
    } finally {
      if(reader!=null) reader.close();
    }
    return occurrences;
  }
}
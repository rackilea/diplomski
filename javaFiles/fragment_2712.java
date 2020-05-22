import java.lang.*;

class test{

    public static void main( String args[] )
    {
       String MySentence = "This is My Word. I'm Going to Find the Average of this";
       System.out.println(" Average Length :"+ getAverageWordLength(MySentence));
    }

    static double getAverageWordLength(String tweeps) {

        // TODO: update the code here to return the average length of
        // words in the tweets processed so far.

        String[] average = tweeps.split(" ");

        int count = 0;
        int sum = 0;
        int currentWordLength;
        String tempString;
        for(int i = 0; i < average.length; i++)
        {
          average[i] = average[i].replaceAll("[^a-zA-Z]", "").toLowerCase();
          tempString = average[i];
          currentWordLength = tempString.length();
          sum += currentWordLength;
          count++;
        }
        double averageWordLength = sum / count;
        return averageWordLength;
    }
}
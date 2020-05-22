package swing_practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestClass {

    private static final File scoreFile = new File("/home/arif/workspace/swing_practice/src/swing_practice/words_score.txt");

    public static void main(String[] args) {        
        try{
            String str = purifySentence("I think what did that fellow does, is good for her but If I speak from that girl side, it's worst kind of thing.");
            int score = 5;
            String[] words = str.split("\\s+");

            for (int i = 0; i < words.length; i++) {
                //System.out.println("Score for the word is : " + words[i] + " - " + getScore(words[i]));
                score += getScore(words[i]);
            }

            //if you want with 3 files, just write three methods like getScore and append the score variable similarly as above

            if(score < 0)
                score = 0;
            if(score > 10)
                score = 10;

            System.out.println("Score of the sentence is : " + score);

        }catch(FileNotFoundException ioe){
            ioe.printStackTrace();
        }

    }

    private static String purifySentence(final String sentence){
        String purifiedValue = "";

        if(sentence.length() == 0){
            return "";
        }else{
            for(int i = 0; i < sentence.length(); i++){
                char ch = sentence.charAt(i);
                if(Character.isAlphabetic(ch) || ch == ' ')
                    purifiedValue += String.valueOf(ch);
            }
        }
        return purifiedValue;
    }

    private static int getScore(final String word) throws FileNotFoundException{
        int score = 0;
        final Scanner scanner = new Scanner(scoreFile);
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            String[] wordNScore = line.split("\t", -1);
               if(wordNScore[0].equalsIgnoreCase(word)) {
                   score = Integer.parseInt(wordNScore[1]);
                   scanner.close();
                   break;
               }
        }
        return score;
    }

}
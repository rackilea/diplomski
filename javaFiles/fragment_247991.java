import java.text.BreakIterator;
import java.util.*;

public class TestCode {

    private static final String[] ABBREVIATIONS = {
        "Dr." , "Prof." , "Mr." , "Mrs." , "Ms." , "Jr." , "Ph.D."
    };

    public static void main(String[] args) throws Exception {

        String text = "Prof. Roberts and Dr. Andrews trying to solve a " +
                      "problem by writing a 1.200 lines of code. This will " +
                      "work if Mr. Java writes solid code.";

        for (String s : breakSentence(text)) {
              System.out.println(s);
        }
    }

    public static List<String> breakSentence(String document) {

        List<String> sentenceList = new ArrayList<String>();
        BreakIterator bi = BreakIterator.getSentenceInstance(Locale.US);
        bi.setText(document);
        int start = bi.first();
        int end = bi.next();
        int tempStart = start;
        while (end != BreakIterator.DONE) {
            String sentence = document.substring(start, end);
            if (! hasAbbreviation(sentence)) {
                sentence = document.substring(tempStart, end);
                tempStart = end;
                sentenceList.add(sentence);
            }
            start = end; 
            end = bi.next();
        }
        return sentenceList;
    }

    private static boolean hasAbbreviation(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return false;
        }
        for (String w : ABBREVIATIONS) {
            if (sentence.contains(w)) {
                return true;
            }
        }
        return false;
    }
}
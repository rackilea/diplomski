import java.util.ArrayList;


public class MarklengthTestDrive {
    public static void main(String[] args){

        ArrayList <String> words = new ArrayList<String>(); 

        words.add("Kane");
        words.add("Cane");
        words.add("Fame");
        words.add("Dame");
        words.add("Lame");  
        words.add("Same");

        Marklength ish = new Marklength();

        words = ish.marklength4(words);

    }
}
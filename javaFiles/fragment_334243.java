import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *  Hello i am a Application that is too lazy to implement the Caesar encoding/ decoding - luckaly someone
 *  made me a Utility for that :)
 *
 *  TODO: This could need some improvement - maybe let the user type in the in/output file in the console?
 *
 */
public class Application {

    // TODO: How i said i am a bit rosty here - was it a number or a character - you know it better than i do i assume :)
    private static final String KEY = "???";

    public static void main(String[] args){
          new Application().start();
    }

    public void start(){

         // lets first encode a file - we need to have a Scanner to be able to use the Utility class (so i searched)
         // SO for "Java Scanner read File" and found this:
        File inputFile = new File("sensitive-data.txt");
        Scanner inputScanner = null;

        try {
            new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            // TODO: Exception handling (does it make sence to proceed in this case? do we have to notify the user about this?
            e.printStackTrace();
        }

        // let the utility encode the file and write it to another file - luckaly searching SO for "Java PrintWriter example"
        // helps us out here
        File outFile = new File ("sensitive-data.txt");
        PrintWriter outWriter = null;
        try {
            outWriter = new PrintWriter (outFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Alright we have both - the input as well as the output and the key - its time to let the utility do its work
        CaesarUtility.encrypt(inputScanner, outWriter, KEY);

        // TODO: Whoopy i accidentially overwritten the source file with encoded data - luckaly i am able to decode it again
        // TODO: Decode the encoded file before the boss asks about the next sensitive-data report :)

    }
}
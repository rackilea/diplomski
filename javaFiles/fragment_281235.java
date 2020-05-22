import java.util.Scanner;
public class WordGenerator {
    /**
     * Tokenizes standard input into words, writing each word to standard output,
     * on per line.  Because it reads from standard input and writes to standard
     * output, it can easily be used in a pipeline combined with sort, uniq, and
     * any other such application.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            System.out.println(input.next().toLowerCase());
        }
    } 
}
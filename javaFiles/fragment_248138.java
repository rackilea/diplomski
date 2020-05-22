package cruft;

import java.io.*;

/**
 * ArrayIndexOutOfBoundsProblem
 * @author Michael
 * @link http://stackoverflow.com/questions/11640904/java-lang-arrayoutofbounds-exception-when-writing-to-a-file
 * @since 7/24/12 7:58 PM
 */
public class ArrayIndexOutOfBoundsProblem {

    public static void main(String[] args) {
        ArrayIndexOutOfBoundsProblem aioob = new ArrayIndexOutOfBoundsProblem();

        int c = ((args.length > 0) ? Integer.valueOf(args[0]) : 10);
        int t = ((args.length > 1) ? Integer.valueOf(args[1]) : 2);
        aioob.printValues(c, t);
    }

    public void printValues(int c, int t){
        printValues(System.out, c, t);
    }

    public void printValues(String outputFilePath, int c, int t) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(outputFilePath);
            PrintStream ps = new PrintStream(fos);
            printValues(ps, c, t);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            close(fos);
        }
    }

    public void printValues(PrintStream ps, int c, int t) {
        ps.println(String.format("c: %10d t: %10d ratio c/t: %10.4f", c, t, (double) c/t));
    }

    public static void close(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
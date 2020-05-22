package cruft;

import java.io.FileOutputStream;
import java.io.PrintStream;

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
        aioob.myMethod(c, t);
    }

    public void myMethod(int C, int T){
        try{
            FileOutputStream fout = new FileOutputStream("output.txt", true );
            PrintStream ps = new PrintStream(fout);
            System.out.println(""+(double)C/T);
            ps.println((double)C/T+"");
            // close file
            fout.close();
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
}
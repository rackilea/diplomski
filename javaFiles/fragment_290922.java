import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class StreamRedirector {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println(Arrays.toString(args));
        //  parse the arguments
        if (args.length != 2) {
            throw new IllegalArgumentException(
                    "Usage:" +
                        "\targ0 = wrapped main FQN;\n" +
                        "\targ1 = dest output file name;\n" +
                        "\tother args are passed to wrapped main;"
            );
        }
        String mainClass = args[0];
        String destinationFile = args[1];

        //  redirect the streams
        PrintStream outErr = new PrintStream(new FileOutputStream(destinationFile));
        System.setErr(outErr);
        System.setOut(outErr);

        //  delegate to the other main
        String[] wrappedArgs = new String[args.length - 2];
        System.arraycopy(args, 2, wrappedArgs, 0, wrappedArgs.length);
        Class.forName(mainClass).getMethod("main", String[].class).invoke(null, (Object) wrappedArgs);
    }
}
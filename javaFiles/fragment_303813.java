import java.io.*;

public class MyClass {

    PrintStream stream;

    {
        stream = new PrintStream("/tmp/file.txt");
    }

    public MyClass() throws FileNotFoundException {
    }

}
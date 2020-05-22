import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // construct a process
            ProcessBuilder pb1 = new ProcessBuilder("ls", "-1");
            // set working directory
            pb1.directory(new File("test"));

            // start process
            final Process process1 = pb1.start();

            // get input/error streams
            final InputStream p1InStream = process1.getInputStream();
            final InputStream p1ErrStream = process1.getErrorStream();

            // handle error stream
            Thread t1Err = new InputReaderThread(p1ErrStream, "Process 1 Err");
            t1Err.start();

            // this will print out the data from process 1 (for illustration purposes)
            // and redirect it to process 2
            Process process2  = new ProcessBuilder("grep", "some").start();

            // process 2 streams
            final InputStream p2InStream = process2.getInputStream();
            final InputStream p2ErrStream = process2.getErrorStream();
            final OutputStream p2OutStream = process2.getOutputStream();

            // do the same as process 1 for process 2...
            Thread t2In = new InputReaderThread(p2InStream, "Process 2 Out");
            t2In.start();
            Thread t2Err = new InputReaderThread(p2ErrStream, "Process 2 Err");
            t2Err.start();

            // create a new thread with our pipe class
            // pass in the input stream of p1, the output stream of p2, and the name of the input stream
            new Thread(new PipeClass(p1InStream, p2OutStream, "Process 1 Out")).start();

            // wait for p2 to finish
            process2.waitFor();

        } catch (IOException e) {
            System.out.println("Command execution error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General error: " + e.getMessage());
        }
    }
}
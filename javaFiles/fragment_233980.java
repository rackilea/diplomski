import java.io.*;
import java.util.Scanner;

public class Murray_A04Q2 {
    public static void main(String[] args) throws IOException {
        String fileName = "userStrings.txt";

        // Here you create a scanner using Standard Input as the input
        // stream. (This is fine)
        Scanner scan = new Scanner(System.in);

        try {
            // You say this is a FileREADER though it is clearly not...
            // fix this comment!
            // Either have remotely correct comments or just remove them.
            FileWriter fileWriter = new FileWriter("userStrings.txt");

            // Once again these are WRITERS not READERS.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter outFile = new PrintWriter(bufferedWriter);
            // Despite bad comments, the above code is NOT a problem.

            // You just created a scanner, using it for input.
            // Why make a second object to read from the SAME input stream?
            // Not only does this cause confusion in how the stream is handled,
            // but its useless code when you already have a Scanner.
            // Remove these two objects and all references to them and
            // replace them with the Scanner reference (or vice versa).
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            // Setting to emptyquotes is useless unless you are using the
            // variable before its next write. Still, not the error.
            String input = "";

            System.out.print("Enter something (DONE to quit): ");

            // Begin problems. You are reading in a line here,
            // and once again, YOU ARE DOING >NOTHING< with it
            // before the next write. In your print you say
            // "DONE to quit" but you are NOT checking if
            // input.equals("DONE")
            input = scan.nextLine();

            while (true) {
                System.out.println("Enter something else or DONE to quit: ");

                // Stream Read number 2, variable write number 3, still you
                // have not READ from the input variable.
                input = scan.nextLine();

                // Stream Read number 3, variable write number 4, still you
                // have not READ from the input variable.
                // Also, despite you using a different reader, this is still
                // accessing and pulling data out of the same input stream.
                // Whatever the Scanner has pulled out is no longer in the
                // input stream.
                input = br.readLine();

                // Finally you are reading the string in the variable
                // 'input'. On the first iteration of the while loop you
                // will have written to input 3 times already. You will
                // only be printing the 3RD LINE of input from the user.
                // Still however, you are not checking if
                // input.equals("DONE") which is supposed to be the
                // condition terminating your loop.
                System.out.println(input);

                // Stream read number 4, variable write number 5, FINALLY
                // checking the user's input against the string "DONE" and
                // terminating the loop. On the first iteration of the loop,
                // this stream read will only see the 4TH line of input from
                // the user.
                if ((input = scan.nextLine()).equalsIgnoreCase("DONE")) {
                    break;
                }

            }

            bufferedWriter.write(input);

            // Closing file
            bufferedWriter.close();
        }

        catch (IOException ex) {
            System.out.println("Error writing to file " + "userStrings.txt"
                    + "");
        }

    } // End of method header
} // End of class header
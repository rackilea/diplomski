package password;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class Password {

    //Makes 50 random passwords(ten characters using letters and numbers)
    public void creator() throws IOException { 

        FileWriter fw = new FileWriter(new File("codes.txt"));
        PrintWriter out = new PrintWriter(fw);

        char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();

        Random random = new Random();

        for (int x = 0; x < 51; x++){
            String word = "";
            for (int i = 0; i <= 10; i++) {

                char c = chars[random.nextInt(chars.length)];
                word+=c;

            }
            out.println(word);
        }
        fw.close();
    }

    //prints passwords for 10 seconds
    public void readit() throws FileNotFoundException, InterruptedException {
        File file = new File("codes.txt");

        Scanner input = new Scanner(file);

        //prints each line in the file
        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
        }
        Thread.sleep(10000);
        input.close();

    }

    //asks for password and if it's correct then states LOGIN COMPLETE and then adds exceptions to a temporary file then readds to main file then closes
    public void checkit() throws FileNotFoundException, IOException, InterruptedException {

        File file = new File("codes.txt");
        FileWriter fw = new FileWriter(new File("code.txt"));
        PrintWriter out = new PrintWriter(fw);


        Scanner reader = new Scanner(file);
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a password");
        String word = input.nextLine();

        //prints each line in the file
        while (reader.hasNextLine()) {

            String line = reader.nextLine();
            if (line.equals(word)) {
                System.out.println("LOGIN COMPLETE");
                Thread.sleep(5000);
            } else {
                out.println(line);
            }
        }
        reader.close();
        fw.close();

        File file2 = new File("code.txt");
        Scanner reader2 = new Scanner(file2);
        FileWriter fw2 = new FileWriter(new File("codes.txt"));
        PrintWriter out2 = new PrintWriter(fw2);

        while (reader2.hasNextLine()) {
            String line = reader2.nextLine();
            out2.println(line);
        }
        file2.delete();
        fw2.close();
        System.exit(0);
    }
}
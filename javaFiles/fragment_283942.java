import java.io.File;
    import java.io.FileNotFoundException;
    import java.util.Scanner;

    public class ArraysIO2 {

        public static void main(String[] args) throws FileNotFoundException {


            // Create File and Scanner objects inside main
            File file = new File("sampledata1.txt");
            Scanner inputFile = new Scanner(file);


            for (int i = 0; i < 10; i++) {
                System.out.println(inputFile.next());
            }
            inputFile.close();
        }


    }
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestScanner {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        boolean fileLoop = true;
        String inputFile = "Computer_Store_DSV.txt";
        String userInputFile;
        File sourceFile = null;
        Scanner record = null;
        do {
            System.out.println("Please enter the path of the file, or press enter to use the default path");
            userInputFile = input.nextLine();

            if (!userInputFile.isEmpty() && new File(userInputFile.concat(inputFile)).exists() ) {
                inputFile=userInputFile.concat(inputFile);
                printState(inputFile,"File found.!");
                sourceFile = new File(inputFile).getAbsoluteFile();
                fileLoop=readFile(sourceFile);
                record = new Scanner(sourceFile);
            }
            else if (new File(inputFile).getAbsoluteFile().exists()){
                sourceFile = new File(inputFile).getAbsoluteFile();
                printState(inputFile,"File found.!");
                fileLoop=readFile(sourceFile);
                record = new Scanner(sourceFile);
            }
            else{
                fileLoop=true;
                printState(inputFile,"File does not exist.!");
            }
        } while (fileLoop);
        input.close();

    }

    public static boolean readFile(File sourceFile){
        if (!sourceFile.canRead()) {
            System.out.println("Unable to read the file");
            return true;
        }
        else
            return false;
    }

    public static void printState(String inputFile,String state){
        System.out.println(state);
        System.out.println("Path used:  " + new File(inputFile).getAbsolutePath()+"\n");
    }
}
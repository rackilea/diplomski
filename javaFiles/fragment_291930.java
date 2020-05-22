import java.util.Stack;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;

public class DelimPos
{
private int linecnt;
private char ch;

public DelimPos(int lineCount, char character)
{
    linecnt = lineCount;
    ch = character;

}

public char getCharacter()
{
    return  ch;
}

public int getLineCount()
{
    return linecnt;
}




public static void main(String args[]) {
    Stack<DelimPos> s = new Stack<DelimPos>();


    int lineCount = 1;


    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a file name: ");
    String inputFile = sc.next();


    try{
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        int text;

        System.out.print(lineCount + ". ");


        while((text = reader.read()) != -1)
        {
            char character = (char) text;
            if(character == '\n')
            {
                System.out.print(character);
                lineCount++;
                System.out.print(lineCount + ". ");

            }
            else System.out.print(character);

            DelimPos d = new DelimPos(lineCount, character);

        }
    }
    catch(IOException e){
        System.out.println("File Not Found");
    }


}


}
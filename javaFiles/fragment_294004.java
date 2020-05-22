import java.util.Scanner;
import java.io.*;
import  java.util.*;

public class Acronym{

  public static void main(String[] args) {
    String phraseToChange = "";
    boolean phraseToChange2 = true;
    int wordCounter = 0;
    char[] acroynmArray = new char [100];
    Scanner input = new Scanner(System.in);
    System.out.println("This program builds acronyms");
    System.out.println("Enter a phrase:");
    String nextLine = input.nextLine();
    StringTokenizer st = new StringTokenizer(nextLine, " ");
    while (st.hasMoreTokens())
    {
      phraseToChange = st.nextToken();
      acroynmArray[wordCounter] = phraseToChange.charAt(0);
      wordCounter++;
    }
    System.out.println("reach here");
    for (int i = 0;i < wordCounter ; i++ )
    {
        System.out.print(acroynmArray[i]);
    }
}
}
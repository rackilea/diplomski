import java.util.Scanner;

import java.util.Random;
public class Words {
  public static void main(String[]args){
    Scanner scan = new Scanner(System.in);
    String words[] = {"Iterate","Petrichor"};
    String input = "";

    while ( !input.equals("start") ) {
       System.out.println("type *start* to begin");
       input = scan.nextLine();
    }

    String random = (words[new Random().nextInt(words.length)]);
  }
}
import java.util.Scanner;
public class Main {
    public static void main(String[] args) 
    {
        String line;
        Scanner input = new Scanner(System.in); 
        int count = 0;
        String shortest = String.format("%0" + 10000 + "d", 0).replace("0", "x");
        String longest = "";

        while (!(line = input.nextLine()).isEmpty()) {

            System.out.println("Enter word:  ");
            count += line.length();

            if (line.length() > longest.length())
                longest = line;
            if(line.length() < shortest.length())
                shortest = line;
        } 
        System.out.println("The total sum of the word lengths entered was: " + count + " words. ");
        System.out.println("The longest word was: " + longest + " with length " + longest.length());
        System.out.println("The shortest word was: "  + shortest + " with length " + shortest.length());
  }
}
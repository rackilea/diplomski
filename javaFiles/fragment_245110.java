import java.util.Scanner;

public class Example {
    public static void main(String[] a) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = scanner.nextLine();
        String cleansed = word.replace("\\s+","");
        char[] letters = cleansed.toCharArray();
        for(char c : letters){
            System.out.print(c+" ");
        }
    }
}
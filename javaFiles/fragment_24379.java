import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MyClass{
    public static void main(String args[]){
        List<String> words = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        for (int i=0; i < 3; i++)
            words.add(input.nextLine());
        System.out.println(words);
    }
}
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Permutation {
    static int c;
    List<String> permutations = new LinkedList<String>();
    Scanner sc=new Scanner(System.in); 
    String input =sc.nextLine();
    int conbinationSize = sc.nextInt();
    boolean[] isChoosed = new boolean[input.length()];
    public void generateCombination(String partialOutput) {
        if (partialOutput.length() == conbinationSize) {
            permutations.add(partialOutput);
            c++;
            return;
        }
        for (int i = 0; i < input.length(); ++i) {
            if (!isChoosed[i]) {
                isChoosed[i] = true;
                generateCombination(partialOutput + input.charAt(i));
                isChoosed[i] = false;      
            }
        }
    }

    void printCombination() {
        for (String c : permutations) {
            System.out.println(c);         
        }
    }
    public static void main(String[] args) {
        Permutation dfs = new Permutation();
        dfs.generateCombination("");
        dfs.printCombination();
        System.out.println(c);
    }
}
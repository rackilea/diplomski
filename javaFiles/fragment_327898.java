import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the key consisting of 5 characters:");
    String input = scanner.next();

    //find positions of '0' in input
    List<Integer> varPositions = findVarPositions(input);

    //create permutations
    List<String> permutations = new ArrayList<>();
    permutations.add(input);//AB0C0
    for (int position : varPositions) {
        permutations = permutateAtPosition(permutations, position);
    }

    //print permutations
    for (String permutation : permutations) {
        System.out.println(permutation.toUpperCase());
    }
}

private static List<Integer> findVarPositions(String input) {
    List<Integer> varPositions = new ArrayList<>();
    int lastVarPosition = -1;
    while ((lastVarPosition = input.indexOf('0', lastVarPosition + 1)) != -1) {
        varPositions.add(lastVarPosition);
    }
    return varPositions;
}

private static List<String> permutateAtPosition(List<String> partialyPermutated, int position) {
    List<String> result = new ArrayList<>();
    char[] replacements = {'1', '2', '3', '4', '5'};
    for (String item : partialyPermutated) {
        for (int i = 0; i < replacements.length; i++) {
            String output = replaceCharAt(item, position, replacements[i]);
            result.add(output);
        }
    }
    return result;
}

private static String replaceCharAt(String input, int position, char replacement) {
    //converting to char array, because there's no method like
    //String.replaceAtPosition(position, char)
    char[] charArray = input.toCharArray();
    charArray[position] = replacement;
    return new String(charArray);
}

}
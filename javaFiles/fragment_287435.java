package pruebas;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 *
 * @author Oscar
 */
public class Permutations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        new PermutatedResult("ABCDEFGHIJKLMNÑOPQRSTUVWXYZ").printPermutations();
    }

}

class PermutatedResult {

    private String input;

    public PermutatedResult(String input) {
        this.input = input;
    }

    public void printPermutations() {

        deferredProcess(s -> System.out.println(s));
    }

    public String[] getPermutations() {
        ArrayList<String> list = new ArrayList<String>((int)Math.pow(2, input.length()));
        deferredProcess(s -> list.add(s));

        return list.toArray(new String[input.length()]);
    }

    public void deferredProcess(Consumer<String> actionForEverySolution) {

        int length = input.length();
        long combinations = (long) Math.pow(2, length);

        StringBuilder combination = new StringBuilder(length);
        for (long i = 0; i < combinations; i++) {

            for (int j = 0; j < length; j++) {

                if (((i >> j) & 1) == 1) {
                    combination.append(input.charAt(j));
                }
            }
            actionForEverySolution.accept(combination.toString());
            combination.setLength(length);
        }
    }
}
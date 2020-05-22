package pruebas;

import java.util.Iterator;

public class Permutations {

    public static void main(String[] args) {

        PermutatedResult result = new PermutatedResult("ABCDEFGHIJKLMNÑOPQRSTUVWXYZ");

        int combinaciones = 0;
        while (result.hasNext()) {
            combinaciones++;
            result.next(); // This line or the next
            //System.out.println(result.next());
        }
        System.out.println(combinaciones);
    }
}

class PermutatedResult implements Iterator<String> {

    private char[] input;
    private Boolean next;
    private byte[] lastCombination;
    private StringBuilder combination;

    public PermutatedResult(String input) {

        /* Some checks, but we need more */
        if (input == null || input.length() == 0) {
            this.next = false;
            return;
        }

        double posibleCombinations = input.length();

        /* Max length of an array... */
        if (posibleCombinations < Integer.MAX_VALUE) {

            this.input = input.toCharArray();
            this.lastCombination = new byte[(int) posibleCombinations];
            this.combination = new StringBuilder(this.input.length);
            this.next = true;
            this.nextCombination();
        }
    }

    @Override
    public boolean hasNext() {
        return this.next;
    }

    @Override
    public String next() {

        if (!next)
            return null;

        combination.setLength(0);

        for (int i = 0; i < input.length; i++) {

            if (lastCombination[i] == 1) /* If we have to use the letter at this position... */
                combination.append(input[i]);
        }

        this.nextCombination();
        return combination.toString();
    }

    private void nextCombination() {

        int remainder = 1;
        int length = lastCombination.length;
        int sum;

        /* Sum 1 to the bits -> 1111 + 1 = 10000 */
        for (int i = 0; remainder == 1 && i < length; i++) {
            sum = ++lastCombination[i];
            remainder = sum >> 1; // This will got the remainder -> 1 + 1 = 10 so shifting (10 >> 1) we got 1 as remainder.
            lastCombination[i] = (byte) (sum & 1); // With this we only take the last bit so 1 + 1 = 10 -> 10 & 1 = 0
        }

        next = remainder != 1; // If there is some remainder we end all the array and finish
    }
}
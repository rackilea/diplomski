package testproject;

import java.util.Arrays;

public class TestProject {

    public static void main(String[] args) {
        String[] numbers = getNumbers(0, 10000000);

        long timestamp = System.currentTimeMillis();
        System.out.println("Starting split");
        String[][] splitted = splitNumbers(numbers);
        System.out.println(System.currentTimeMillis() - timestamp);

        timestamp = System.currentTimeMillis();
        System.out.println("Starting split");
        splitted = splitNumbers(numbers);
        System.out.println(System.currentTimeMillis() - timestamp);
    }

    public static String[] getNumbers(int from, int to){
        String[] res = new String[to-from];
        for(int i=0; i<(to-from); i++){
            res[i] = Integer.toString(from + i);
        }
        return res;
    }

    public static String[][] splitNumbers(String[] numbers){
        int size = numbers.length;
        String[][] numberssplit = new String[4][];
        numberssplit[0] = Arrays.copyOfRange(numbers, 0, size/4);
        numberssplit[1] = Arrays.copyOfRange(numbers, (size/4), size/2);
        numberssplit[2] = Arrays.copyOfRange(numbers, (size/2), 3*(size/4));
        numberssplit[3] = Arrays.copyOfRange(numbers, (3*(size/4)), size);
        return numberssplit;
    }
}
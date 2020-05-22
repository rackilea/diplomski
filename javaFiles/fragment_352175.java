import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Randomizer {

    public static int[] one = { 5, 9, 11 },
            two = { 2, 3, 5, 6, 10, 11, 13, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 13, 1, 2, 6, 7, 9, 5, 6, 9, 10, 11, 12 },
            three = { 1, 2, 4, 1, 2, 3, 7, 8, 1, 2, 4, 6, 7, 8 }, 
            four = { 1, 2, 4, 5, 6 },
            five = { 1, 2, 5, 6, 9, 11, 12 }, 
            six = { 1, 2, 5, 6, 9, 11, 12 };

    public static String[] LETTERS = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
            "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "AA", "BB", "CC" };

    public static Map<Integer, List<Integer>> buildCombinationMap() {
        Map<Integer, List<Integer>> combos = new HashMap<Integer, List<Integer>>();
        combos.put(1, IntStream.of(one).boxed().collect(Collectors.toList()));
        combos.put(2, IntStream.of(two).boxed().collect(Collectors.toList()));
        combos.put(3, IntStream.of(three).boxed().collect(Collectors.toList()));
        combos.put(4, IntStream.of(four).boxed().collect(Collectors.toList()));
        combos.put(5, IntStream.of(five).boxed().collect(Collectors.toList()));
        combos.put(6, IntStream.of(six).boxed().collect(Collectors.toList()));
        return combos;
    }

    public static void main(String[] args) {

        int[] nums = new int[2000];

        for (int i = 0; i < nums.length; i++) {

            Integer[] arr = new Integer[5];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = j + 2;
            }
            Collections.shuffle(Arrays.asList(arr));

            for (int j = 0; j < arr.length; j++) {
                if (i < nums.length) {
                    nums[i] = arr[j];
                }
            }

        }

        String numbers = Arrays.toString(nums);
        numbers = numbers.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").replaceAll(" ", "");

        StringBuilder generatedInput = new StringBuilder();

        // Phase 1
        // Generate a sequence of the numbers 2-6 in a random fashion
        // There must be three different numbers before repeating the same number
        int[] nextValidPos = { -1, -1, -1, -1, -1, -1 };
        int pos = 0;
        while (generatedInput.length() < 183) {
            int nextNumber = Integer.valueOf(numbers.substring(pos, pos + 1));
            if (nextValidPos[nextNumber - 1] <= generatedInput.length()) {
                generatedInput.append(nextNumber);
                nextValidPos[nextNumber - 1] = generatedInput.length() + 3;
            }
            pos++;
        }

        // Phase 2
        // Now the ones are randomly inserted so that a one appear in a seven digit sequence by pattern, 1, 2, 4, 5, 7, 8..
        Random r = new Random();
        for (int i = 0; i<10; i++) {
            int oneOffset1 = r.nextInt(7);
            int oneOffset2 = 7+r.nextInt(7);
            if ((oneOffset2 - oneOffset1) < 4)
                oneOffset2 = oneOffset1+4;
            int baseOffset = i*21;
            generatedInput.insert(baseOffset+oneOffset1, 1);
            generatedInput.insert(baseOffset+oneOffset2, 1);
        }

        System.out.println("Input string len="+generatedInput.toString().length());
        showLines(generatedInput.toString());

        String solution = solveCombination(generatedInput.toString());
        System.out.println(solution);

        //generateFile(getIntArrayFromString(generatedInput.toString()));
        System.out.println("Done");

    }

    public static final int SOLUTION_LEN = 29*7;

    public static String solveCombination(String keys) {
        Map<Integer, List<Integer>> comboMap = buildCombinationMap();
        int columnPlaceHolder[] = {0, 0, 0, 0, 0, 0};   // Holds the column location; start at 'A'
        int[] nextValidPos = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }; // 13 slots needed; max value=13
        StringBuilder solution = new StringBuilder();
        int pos = 0;
        int keySize = 0;
        while (pos < SOLUTION_LEN) {
            int nextNumber = Integer.valueOf(keys.substring(pos, pos + 1));
            //System.out.println("Pos=" + pos + "; Working on: " + nextNumber);
            boolean found = false;
            // Search for the next available combo
            while (!found) {
                int i = comboMap.get(nextNumber).get(columnPlaceHolder[nextNumber-1]);
                //System.out.println("Trying=" + i);
                if (nextValidPos[i - 1] <= pos) {
                    solution.append(nextNumber);
                    solution.append(LETTERS[columnPlaceHolder[nextNumber-1]]);
                    if (pos < SOLUTION_LEN - 1)
                        solution.append("-");
                    nextValidPos[i - 1] = pos + 4;
                    //System.out.println("SOLUTION=" + solution.toString());
                    found = true;
                    keySize++;
                }
                // Move to next position, and wrap back to A if you reach the end
                columnPlaceHolder[nextNumber-1]++;
                if (columnPlaceHolder[nextNumber-1] == comboMap.get(nextNumber).size())
                    columnPlaceHolder[nextNumber-1] = 0;
                }
            pos++;
        }
        System.out.println("Key size="+keySize);
        return solution.toString();
    }

    public static void show(String s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.substring(i, i + 1));
            if (i != s.length() - 1)
                System.out.print("-");
        }
    }

    public static void showLines(String s) {
        for (int i = 0; i < s.length()/7; i++) {
            System.out.println(s.substring(i*7, i*7 + 7));
        }
    }

    public static int[] getIntArrayFromString(String s) {
        int[] array = new int[203];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.valueOf((s.substring(i, i + 1)));
        }
        return array;
    }

    public static void generateFile(int[] array) {
        PrintWriter writer;

        int cur = -1;

        try {
            writer = new PrintWriter("combos.txt");

            for (int i = 0; i < array.length; i++) {
                if (cur + 7 == i) {
                    cur = i;
                    writer.println(array[i]);
                } else {
                    writer.print(array[i]);
                }
            }

            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
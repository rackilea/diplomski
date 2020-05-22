package test;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class LongestStreak {

    static class Result {
        int maximumSequenceLength;
        int[] occurrenceIndices;

        public String toString() {
            return "max. seq. length: " + maximumSequenceLength + ", at " + Arrays.toString(occurrenceIndices);
        }
    }

    public static void main(String[] args) {
        List<Boolean> input = Arrays.asList(
//              new Boolean[] { true, true, false, false, true, true, true, false, true, false, true, true, true, false }
//              new Boolean[] { true, true }
//              new Boolean[] { true, false, true }
                new Boolean[] { true, false, true, true }
                );

        TreeMap<Integer, Result> resultMap = new TreeMap<>();

        boolean last = false;
        Result tmp = null;

        for (int i = 0; i < input.size(); i++) {
            boolean actual = input.get(i);
            if (!last && actual) {
                System.out.println("new sequence starts: " + i);
                tmp = new Result();
                tmp.occurrenceIndices = new int[] { i }; 
            }
            if (actual) {
                System.out.println("new sequence continues: " + i);
                tmp.maximumSequenceLength++;
            }
            if (!actual && last 
                    //or collection ends
                    || i == input.size() - 1) {
                System.out.println("new sequence ends: " + i);
                System.out.println(tmp);
                Result present = resultMap.get(tmp.maximumSequenceLength);
                if (present != null) {
                    System.out.println("append occurrence to existing maximum sequence of " + tmp.maximumSequenceLength);
                    int[] dest = new int[present.occurrenceIndices.length + 1]; 
                    dest[present.occurrenceIndices.length] = tmp.occurrenceIndices[0];
                    System.arraycopy(present.occurrenceIndices, 0, dest, 0, present.occurrenceIndices.length);
                    present.occurrenceIndices = dest;
                } else {
                    System.out.println("new maximum sequence length of " + tmp.maximumSequenceLength);
                    resultMap.put(tmp.maximumSequenceLength, tmp);
                }
            }

            last = actual;
        }

        if (resultMap.isEmpty()) {
            System.out.println("collection contains any trues");
        } else {
            System.out.println("Result: " + resultMap.lastEntry().getValue());
        }
    }
}
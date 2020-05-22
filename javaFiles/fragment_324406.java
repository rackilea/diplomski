import java.util.*;

public class DiceRolls {
    /* The number of trials to run. */
    private static final int NUM_TRIALS = 1000;

    public static void main(String[] args) {
        Random rand = new Random();

        int totalRuns = 0;
        for (int i = 0; i < NUM_TRIALS; i++) {
            totalRuns += runsUntilEvent(rand);
        }
        System.out.println(totalRuns / (double)NUM_TRIALS);
    }

    private static int runsUntilEvent(Random rand) {
        /* Track how many tries we needed. */
        int numTries = 0;
        while (true) {
            numTries++;

            /* Rather than indexing from 1 to 6, I'm indexing from 0 to 5. */
            int freq[] = new int[6];            
            for(int roll = 0; roll < 1000; roll++){
                ++freq[rand.nextInt(6)];
            }

            /* See if this isn't in the hundreds. */
            for(int face = 0; face < freq.length; face++){                
                if (freq[face] >= 200 || freq[face] <= 99) {
                    return numTries;
                }
            }
        }
    }
}
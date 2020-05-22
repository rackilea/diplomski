import java.io.*;
import java.util.Random;

public class CoinFlip {
    public static void main(final String[] args) throws IOException {

        // declare in as a BufferedReader; used to gain input from the user
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        //declare variables
        System.out.println("How many times would you like to flip your coin?");
        final int flips = Integer.parseInt(in.readLine());;

        if (flips > 1000) {
            System.out.println("Invalid input, restart program!");
            return;
        }

        System.out.println("You want to flip " + flips + " times");
        final int[] counters = new int[10],
                     side     = new int[2];

        int r=0,x,max=0;
        final Random rand = new Random();

        for(x = 0; x < flips; ++x) {
            r = rand.nextInt(10);
            System.out.println(r+1);
            counters[r]++;
        }

        for ( x = 0; x < counters.length; ++x )
        {
            System.out.println("You rolled " + (x+1) + " " + counters[x] + " times.");
            if ( counters[x] > max )
            {
                max = counters[x];
                r = x+1;
            }
            side[x%2] += counters[x];
        }

        System.out.println(r + " was rolled most.");
        System.out.println("You rolled " + side[0] + " heads and " + side[1] + " tails." );
    }
 }
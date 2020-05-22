package se.wederbrand.stackoverflow;

import java.util.HashMap;

public class RandomWalk {

    public static final int NBR_WALKS = 100;
    public static final int NBR_STEPS = 500;

    public static void main(String[] args) {
        HashMap<Integer, Integer> totals = new HashMap<>();
        for (int i = -NBR_STEPS; i <= NBR_STEPS; i++) {
            totals.put(i, 0);
        }

        for (int i = 0; i < NBR_WALKS; i++) {
            int total_value = 0;
            for (int j = 0; j < NBR_STEPS; j++) {
                int L = (int) (Math.random() * 2);
                total_value += (L == 0) ? -1 : 1;
            }

            System.out.println("For run number " + i + " the total is " + total_value);
            totals.put(total_value, totals.get(total_value) + 1);
        }

        System.out.println("Number of times you ended on -5 " + totals.get(-5));
    }
}
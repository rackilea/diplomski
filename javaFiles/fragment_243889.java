package com.example.hadoop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * I took your original code posting (which differs somewhat from the second
 * snippet) and I converted it into a stand alone Java program with mock test
 * data.
 * 
 * This program would be my starting point to finding the logic error.
 * 
 * My approach was to (1) isolate your algorithm, (2) mock out a minimal set of
 * input data to test just the algorithm, and (3) step through with the debugger
 * and/or use some trace statements.
 * 
 * I made assumptions about variable definitions based on the code and
 * information provided since I could not see all the actual definitions.
 * 
 * Some of your data types differ between your two code fragments so I was a bit
 * unsure about that.
 * 
 * I may be wrong on some of the variable definitions so modify these as needed.
 * 
 * You mentioned that:
 * 
 * Expected result: 1 1,1,1,2,2 2 1,1,2,2,2 3 2,3,3,3
 * 
 * Actual result: 1 1,1,1 2 1,1,2,2,2 3 2,3,3,3
 * 
 * Massively truncated test data: 1 2105 1 1953 1 1339 2 2105 2 1321 2 1339 3
 * 1321 3 1544 3 1222
 */
public class HadoopTestApp {

    /*
     * Mock test variables.
     */
    ArrayList<Integer> datalist1 = new ArrayList<Integer>(Arrays.asList(2105, 1953, 1339));
    ArrayList<Integer> datalist2 = new ArrayList<Integer>(Arrays.asList(2105, 1321, 1339));
    ArrayList<Integer> datalist3 = new ArrayList<Integer>(Arrays.asList(1321, 1544, 1222));
    TreeMap<Integer, ArrayList<Integer>> treemap = new TreeMap<Integer, ArrayList<Integer>>();
    TreeMap<Integer, ArrayList<Integer>> treemap2 = new TreeMap<Integer, ArrayList<Integer>>();
    String str2 = "";

    /**
     * Use the default constructor to complete the initialization of mock test
     * variables.
     */
    public HadoopTestApp() {

        treemap.put(1, datalist1);
        treemap.put(2, datalist2);
        treemap.put(3, datalist3);
    }

    /**
     * Bootstrap the test.
     * 
     * @param args Command line arguments are not currently used.
     */
    public static void main(String[] args) {
        new HadoopTestApp().run(args);
    }

    /**
     * If you prefer to trace variables manually. Or you can set some breakpoints
     * and inspect variables in the debugger.
     */
    public void doTrace(String label, Object o) {
        System.out.print(label + ": ");
        System.out.println(o);
    }

    /**
     * Run the test of Hooch's algorithm.
     * 
     * @param args Command line arguments are not currently used.
     */
    public void run(String[] args) {

        doTrace("treemap", treemap); // NEW

        ArrayList<Integer> currentArray;
        ArrayList<Integer> compareArray;

        // Setting user friend list

        // cycle users "i"
        for (int i = 1; i <= treemap.size(); i++) {
            currentArray = treemap.get(i);

            // cycle user "k"
            for (int k = 1; k <= treemap.size(); k++) {
                // if(i!=k){ Put back in once working
                compareArray = treemap.get(k);
                // cylce "k"s movie list
                for (int l = 0; l < compareArray.size(); l++) {
                    if (currentArray.contains(compareArray.get(l))) {
                        // NEW I set a debugger breakpoint on this line to inspect all variables
                        if (treemap2.containsKey(i)) {
                            ArrayList<Integer> list3 = treemap2.get(i);
                            list3.add(k);
                            treemap2.remove(i);
                            treemap2.put(i, list3);
                            doTrace("contains key, treemap2", treemap2); // NEW
                        }
                        if (!treemap2.containsKey(i)) {
                            ArrayList<Integer> list4 = new ArrayList<Integer>();
                            list4.add(k);
                            treemap2.put(i, list4);
                            doTrace("does not contain key, treemap2", treemap2); // NEW
                        }
                    }
                }
            }
        }

        // Create string of friends
        for (ArrayList<Integer> x : treemap2.values()) {
            str2 = Integer.toString(x.get(0));
            for (int i = 1; i < x.size(); i++) {
                str2 = str2 + "," + Integer.toString(x.get(i));
            }
            doTrace("in loop str2", str2); // NEW
        }

        // context.write(key, new Text(str2));
        doTrace("context.write str2", str2); // NEW

    }

}
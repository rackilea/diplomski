import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Driver {

    public static void main(String[] args) {
        Scanner in = null;
        String inputStr = "";

        try {
            // open the file "xin.txt" to retrieve input
            in = new Scanner(new File("xin.txt"));
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        // read the data into a one line string
        while(in.hasNext()) {
            inputStr += in.nextLine().trim() + " ";
        }
        System.out.println("[ORIGINAL]\n" + inputStr + "\n");

        System.out.println("[Start Sorting]");
        inputStr = sortString(inputStr);
        System.out.println("[Done Sorting]\n");

        System.out.println("[Sorted String]\n" + inputStr);
    }

    private static String sortString(String orig) {
        String one = "";
        String two = "";
        int oneStart = 0; // starting index of string to compare with
        int twoStart = 0; // starting index of string to compare against
        int oneStop = 0; // ending index of string to compare with
        int twoStop = 0; // ending index of string to compare against
        int oneTot = 0; // length of string one plus the grades
        int twoTot = 0; // length of string two plus the grades

        int cp = 0; // current position (index)

        boolean onOne = false; // current position is on one
        boolean onTwo = false; // current position is on two
        boolean passOne = false; // passed string one
        boolean passTwo = false; // passed string two


        boolean notDone = true; // control boolean

        while(notDone) {
            if(cp >= orig.length() || isAtoZ(orig.charAt(cp))) {
                if(!onOne && !passOne) {
                    oneStart = cp;
                    onOne = true;
                } else if(passOne && (!onTwo && !passTwo)) {
                    twoStart = cp;
                    onTwo = true;

                    // total length of the first string is the current position
                    // minus the start of the first string
                    oneTot = cp - oneStart;
                } else if(passTwo) {
                    // total length of the second string is the current position
                    // minus the start of the second string
                    twoTot = cp - twoStart;

                    one = orig.substring(oneStart, oneStop);
                    two = orig.substring(twoStart, twoStop);

                    // output the results of the comparing
                    System.out.println(orig);
                    System.out.println("Comparing: " + one + " to " + two);
                    System.out.println("Result: " + one.compareTo(two) + "\n");



                    // if the first string is alphabetically larger, then swap
                    // and restart sort,else continue to the next comparison
                    if(one.compareTo(two) > 0) {
                        orig = rangeSwap(oneStart, oneStart + oneTot,
                        twoStart, twoStart + twoTot, orig);
                        onOne = false;
                        onTwo = false;
                        passOne = false;
                        passTwo = false;

                        cp = -1;
                    } else {
                        onOne = false;
                        onTwo = false;
                        passOne = false;
                        passTwo = false;

                        cp = twoStart - 1;
                    }

                }
            } else {
                if(onOne && !passOne) {
                    oneStop = cp;
                    passOne = true;
                    onOne = false;
                } else if(onTwo && !passTwo) {
                    twoStop = cp;
                    passTwo = true;
                    onTwo = false;
                }
            }

            // increment the current position by one
            cp = cp + 1;

            // the last string has no string to compare to so
            // set the control boolean
            if(cp >= (orig.length()-1) && (!passTwo)) {
                notDone = false;
            }
        }

        // return the sorted string
        return orig;
    }

    private static String rangeSwap(int ob, int oe, int tb, int te, String s) {
        String start = "";
        String x = "";
        String middle = "";
        String y = "";
        String end = "";

        start = s.substring(0, ob);
        x = s.substring(ob, oe);
        middle = s.substring(oe, tb);
        y = s.substring(tb, te);
        end = s.substring(te);

        return start + y + middle + x + end;
    }

    private static boolean isAtoZ(char what) {
        // ASCII character codes: A to Z = 65 to 90
        //                        a to z = 97 to 122
        return (((int)what >= 65 && (int)what <= 90) ||
        ((int)what >= 97 && (int)what <= 122 ));
    }

}
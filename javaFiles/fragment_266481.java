import java.util.*;
import java.lang.*;

class Main {

    public static void expandPLA(char[] pla) {

        // How many don't cares are we handling
        int empties = 0;
        for (int i = 0; i < pla.length; i++) {
            if (pla[i] == '-') { empties++; }
        }

        // Now we know we're counting from 0 to 2^empties in binary
        for (int j = 0; j < Math.pow(2,empties); j++) {

            // For each value of j we're going to create a new string pattern
            // and fill in each don't care with the correct digit of j
            String pattern = String.copyValueOf(pla);
            String bin = Integer.toBinaryString(j);

            // Pad bin with zeros
            int pad = empties - bin.length();
            for (int z = 0; z < pad; z++) {
                bin = "0" + bin;
            }

            // For each empty spot we're going to replace a single '-' with
            // the next most significant digit
            for (int k = 0; k < empties; k++) {
                char digit = bin.charAt(k);
                pattern = pattern.replaceFirst("-", String.valueOf(digit));
            }

            // We're just going to print this out for now, but you can do
            // whatever it is you want at this point.
            System.out.println(pattern);

        }

    }

    public static void main (String[] args) throws java.lang.Exception {
        Main.expandPLA(new char [] { '1', '-', '-', '1', '-', '1', '-', '-' });
    }

}
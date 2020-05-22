import java.util.Arrays;

public class Vampire {

    final static int START = 10, END = 10000;

    public static void main(String[] args) {

        for (int fangA = START; fangA < END; fangA++) {

            String sFangA = String.valueOf(fangA);
            boolean trailingZeros = sFangA.endsWith("0");           
            int max = (int) Math.min(END, Math.pow(10, sFangA.length()));

            for (long fangB = fangA; fangB < max; fangB++) {

                long candidate = fangA * fangB;
                if (candidate % 9 == (fangA + fangB) % 9) {  

                    String sCandidate = String.valueOf(candidate);
                    String sFangB = String.valueOf(fangB);

                    if ((trailingZeros && sFangB.endsWith("0")) == false) {

                        char[] cVampire = sCandidate.toCharArray();
                        Arrays.sort(cVampire);

                        char[] cFangs = (sFangA + sFangB).toCharArray();
                        Arrays.sort(cFangs);

                        if (Arrays.equals(cVampire, cFangs)) {
                            System.out.println(sFangA + " * " + sFangB + " = " + sCandidate);
                        }
                    }
                }
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class GaleShapley {
    private int N, engagedCount;
    private String[][] menPref;
    private String[][] womenPref;
    private String[] men;
    private String[] women;
    private String[] womenPartner;
    private boolean[] menEngaged;

    /** Constructor **/
    public GaleShapley() {

    }

    public GaleShapley(String[] m, String[] w, String[][] mp, String[][] wp) {
        N = mp.length;
        engagedCount = 0;
        men = m;
        women = w;
        menPref = mp;
        womenPref = wp;
        menEngaged = new boolean[N];
        womenPartner = new String[N];
        calcMatches();
    }

    /** function to calculate all matches **/
    private void calcMatches() {
        while (engagedCount < N) {
            int free;
            for (free = 0; free < N; free++)
                if (!menEngaged[free])
                    break;

            for (int i = 0; i < N && !menEngaged[free]; i++) {
                int index = womenIndexOf(menPref[free][i]);
                if (womenPartner[index] == null) {
                    womenPartner[index] = men[free];
                    menEngaged[free] = true;
                    engagedCount++;
                } else {
                    String currentPartner = womenPartner[index];
                    if (morePreference(currentPartner, men[free], index)) {
                        womenPartner[index] = men[free];
                        menEngaged[free] = true;
                        menEngaged[menIndexOf(currentPartner)] = false;

                    }
                    engagedCount++;

                }

            }
        }
        printCouples();
    }

    /** function to check if women prefers new partner over old assigned partner **/
    private boolean morePreference(String curPartner, String newPartner, int index) {
        for (int i = 0; i < N; i++) {
            if (womenPref[index][i].equals(newPartner))
                return true;
            if (womenPref[index][i].equals(curPartner))
                return false;
        }
        return false;
    }

    /** get men index **/
    private int menIndexOf(String str) {
        for (int i = 0; i < N; i++)
            if (men[i].equals(str))
                return i;
        return -1;
    }

    /** get women index **/
    private int womenIndexOf(String str) {
        for (int i = 0; i < N; i++) {
            if (women[i].equals(str))
                return i;
        }

        return -1;
    }

    /** print couples **/
    public void printCouples() {
        System.out.println("Couples are : ");
        for (int i = 0; i < N; i++) {
            System.out.println(womenPartner[i] + " " + women[i]);
        }
    }

    /** main function **/
    public static void main(String[] args) {
        System.out.println("Gale Shapley Marriage Algorithm\n");
        /** list of men **/
        String[] m = { "1", "2", "3" };
        /** list of women **/
        String[] w = { "1", "2", "3" };

        /** men preference **/

        String[][] mp = null;
        /** women preference **/
        String[][] wp = null;

        try {
            FileInputStream fstream = new FileInputStream("C:\\Users\\Youssef\\Projects\\STS\\TEST\\src\\input");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            int line = 0;
            int n = 0;
            int i = 0;
            while ((strLine = br.readLine()) != null) {
                if (line == 0) {
                    n = Integer.valueOf(strLine.trim());
                    mp = new String[n][n];
                    wp = new String[n][n];
                    line++;
                } else {
                    if (strLine != null && !strLine.equals("") && !strLine.contains("male")
                            && !strLine.contains("female")) {
                        String[] preferences = strLine.split(" ");

                        if (i < n) {
                            mp[i] = preferences;
                        } else {
                            if (i - n < w.length) {
                                wp[i - n] = preferences;

                            }
                        }
                        i++;
                    }

                }
            }
            in.close();

            new GaleShapley(m, w, mp, wp);

        } catch (Exception e) {// Catch exception if any
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }
    }

}
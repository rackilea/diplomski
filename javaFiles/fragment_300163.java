import javax.swing.JOptionPane;
public class TreeNode {
    public static int eingabe(int eingabe) {
        if (eingabe > 0) { // Needed to reverse this
            evenSum1(eingabe, 0, 0);
        } else {
            evenSum2(eingabe, 0, 0);
        }

        return 0;
    }

    public static int evenSum2(int eingabe, int summe, int zaehler) {
        if (PevenSum(eingabe, summe, zaehler) == 0) {
            System.out.print("Die Summe aller geraden Zahlen ist: " + summe);
            return 0;
        }
        zaehler = zaehler - 2;
        summe = summe + zaehler; // Needed to change this to add rather than
                                    // subtract (subtracting a negative number
                                    // makes it positive)
        evenSum2(eingabe, summe, zaehler);
        return 1;

    }

    public static int evenSum1(int eingabe, int summe, int zaehler) {
        if (NevenSum(eingabe, summe, zaehler) == 0) {
            System.out.print("Die Summe aller geraden Zahlen ist: " + summe);
            return 0;
        }
        zaehler = zaehler + 2;
        summe = summe + zaehler;
        evenSum1(eingabe, summe, zaehler);
        return 1;
    }

    public static int NevenSum(int eingabe, int summe, int zaehler) {
        if (zaehler == eingabe || zaehler == (eingabe - 1)) { // Changed from
                                                                // zaehler ==
                                                                // (eingabe + 1)
            return 0;
        }
        return 1;
    }

    public static int PevenSum(int eingabe, int summe, int zaheler) {
        if (zaheler == eingabe || zaheler == eingabe + 1) { // Can't compare the
                                                            // sum, have to
                                                            // compare counter
                                                            // and eingabe
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        String eingabe;
        eingabe = JOptionPane.showInputDialog("Hier eine Zahl eingaben");
        int zahl = Integer.parseInt(eingabe);
        eingabe(zahl);
    }
}
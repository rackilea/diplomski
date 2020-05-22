import java.text.DecimalFormat;
import java.util.Scanner;

public class Luottolaskuri {

    private static Scanner lukija;

    public static void main(String[] args) {
        lukija = new Scanner(System.in);
        System.out.print("Anna luotollisen ostoksen hinta: ");
        double loh = lukija.nextDouble();
        System.out.print("Anna kuukausierien lukumäärä: ");
        int kkelkm = lukija.nextInt();
        int counter = 1;
        double lasku = loh / kkelkm; // initialize outside the loop
        double viimlasku = loh; // initial value
        while (counter <= kkelkm) { // use # of iterations, not a hardcoded value
            viimlasku -= lasku; // substract
            DecimalFormat kaksiDesimaalia = new DecimalFormat("0.00");
              String muotoiltu = kaksiDesimaalia.format(lasku);
              String muotoiltu2 = kaksiDesimaalia.format(viimlasku);
            System.out.println(counter + ". erä "+ muotoiltu +" euroa, luottoa jäljellä " + muotoiltu2 + " euroa");
            counter++;
        }

    }

}
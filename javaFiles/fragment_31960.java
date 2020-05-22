import java.util.Scanner;

public class ValueIncrease {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int tierNo;
        double value;
        double[] minList; // changed var naming convention
        double[] incList;

        System.out.printf("\nHow many tiers are there?");
        tierNo = s.nextInt();
        // fixed allocation
        minList = new double[tierNo];
        incList = new double[tierNo];

        System.out.printf("\nEnter the minimum amounts to reach the next tiers.");
        System.out.printf("\n(Remember to seperate by commas.)");
        s.nextLine();
        String minStr = s.nextLine();
        String minStrList[] = minStr.split(",");
        System.out.printf("\nEnter the increase for each tier.");
        System.out.printf("\n(Seperate by commas.)");
        String incStr = s.nextLine();
        String incStrList[] = incStr.split(",");

        for (int i = 0; i < tierNo; i++) { // fixed loop max
            try {
                minList[i] = Double.parseDouble(minStrList[i]);
                incList[i] = Double.parseDouble(incStrList[i]);
            } catch (NumberFormatException nfe) {}
        } // end for

        while (true) { // added while loop for more efficient testing

            System.out.printf("\nEnter value (negative to exit): ");
            value = s.nextDouble();
            if (value < 0.0) break;

            // calculate value
            for (int i = tierNo-1; i >= 0; i--) { // changed loop direction
                if (value >= minList[i]) {
                    value = value + incList[i];
                    break; // added break
                } // end if
            } // end for

            System.out.printf("Result: %f", value ); // added print statement

        } // end while

    } // end main()

} // end class ValueIncrease
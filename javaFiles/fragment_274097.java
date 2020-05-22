public class Rain {

public static void main(String[] args) {
    // Create an array of rainfall figures.
    double[] thisYear = { 1.6, 2.1, 1.7, 3.5, 2.6, 3.7, 3.9, 2.6, 2.9, 4.3,
            2.4, 3.7 };

    int high; // The high month
    int low; // The low month

    // Create a RainFall object initialized with the figures
    // stored in the thisYear array.
    Rainfall r = new Rainfall(thisYear);

    // Display the statistics.
    System.out.println("The total rainfall for this year is "
            + r.getTotalRainFall());
    System.out.println("The average rainfall for this year is "
            + r.getAverageRainFall());
    high = r.getHighestMonth();
    System.out.println("The month with the highest amount of rain " + "is "
            + (high + 1) + " with " + r.getRainAt(high) + " inches.");
    low = r.getLowestMonth();
    System.out.println("The month with the lowest amount of rain " + "is "
            + (low + 1) + " with " + r.getRainAt(low) + " inches.");
  }
 }
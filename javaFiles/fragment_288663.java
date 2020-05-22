public class ARRAYminAndmax0RichterScale {
    public static void main(String[] args) {
        double[] quakeLevels = { 5.6, 6.2, 4.0, 5.5, 5.7, 6.1, 7.4, 8.5, 5.5,
                6.3, 6.4, 2.1, 6.9, 4.3, 3.1, 7.0, 10.1 };
        int i;
        int minIndex = 0; // start with 0th element as min
        for (i = 1; i < quakeLevels.length; i++) {
            if (quakeLevels[i] < quakeLevels[minIndex]) {
                minIndex = i;
            }
        }
        System.out.print("Min: " + quakeLevels[minIndex] + "    ");
        int maxIndex = 0; // start with 0th element as max
        for (i = 1; i < quakeLevels.length; i++) {
            if (quakeLevels[i] > quakeLevels[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println("Max: " + quakeLevels[maxIndex]);
        System.out.println();
        System.out.println("The Richter values, excluding the extrema, are as follows: ");
        double arrayTotal = 0;
        // make a new array excluding the max and min
        for (i = 0; i < quakeLevels.length; i++) {
            if (i != minIndex && i != maxIndex) {
                System.out.printf("%6s\n", quakeLevels[i]);
                arrayTotal += quakeLevels[i];
            }
        }
        double average = arrayTotal / (quakeLevels.length - 2);
        // output
        System.out.printf("%s%.1f\n", "Average Quake Level = ", average);
    }

}
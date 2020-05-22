import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ReadingLargeFile {
    static String[] words;
    static Map<String, double[]> m1 = new TreeMap();
    static Map<String, Double> m2 = new TreeMap();

    public static void main(String args[]) {
        //First TreeMap
        double count[] = {3.9, 1.2, 6.2, 1.8, 7.6, 3.8};
        double count1[] = {1.6, 7.2, 6.2, 2.3, 1.8, 0.0};
        double count2[] = {1.6, 5.5, 1.8, 8.8, 0.0, 0.0};
        double count3[] = {0.0, 0.0, 0.0, 2.3, 0.0, 0.0};
        double count4[] = {2.0, 2.2, 1.2, 3.9, 2.3, 4.4};
        double count5[] = {3.4, 0.0, 1.9, 2.4, 0.5, 2.0};
        m1.put("apple", count);
        m1.put("orange", count1);
        m1.put("banana", count2);
        m1.put("cherry", count3);
        m1.put("lemon", count4);
        m1.put("strawbarry", count5);

        //second TreeMap
        m2.put("apple", 2.1);
        m2.put("cherry", 1.9);
        m2.put("grasb", 3.0);
        m2.put("strawbarry", 4.1);

        double[][] addedresults = getFinalSums(m1, m2);
        double[] finalResults = getSummedColumns(addedresults);

        System.out.println("added value arrays: " + Arrays.deepToString(addedresults));
        System.out.print("final summed array: " + Arrays.toString(finalResults));

    }

    public static double[] getSummedColumns(double[][] array) {
        double[] results = new double[array.length];
        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < array.length; j++) {
                results[i] += array[j][i];
            }
        }
        return results;
    }

    public static double[][] getFinalSums(Map<String, double[]> m1, Map<String, Double> m2) {

        int sharedSums = 0;
        for (Map.Entry<String, Double> entry : m2.entrySet())
            if (m1.containsKey(entry.getKey()))
                sharedSums++;

        double[][] finalSum = new double[sharedSums][];

        int i = 0;
        for (Map.Entry<String, Double> entry : m2.entrySet()) {//for loop through the second TreeMap
            if (m1.containsKey(entry.getKey())) {//check if the first TreeMapp contain same key from second TreeMap
                //if the key is common in m1 and m2, multiply the values

                double y = entry.getValue();//the number from second TreeMap
                double w[] = m1.get(entry.getKey());//the array from first TreeMap

                finalSum[i] = new double[w.length]; // instantiate the new array in the 2d array

                for (int j = 0; j < w.length; j++) {
                    finalSum[i][j] = w[j] * y; // add in the values in the correct spot in the 2d array
                }
                i++; // increase the current spot in the 2d array
            }
        }
        return finalSum;
    }
}
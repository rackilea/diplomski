import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;

public class findstrings {

    static List<String> keys = new ArrayList<String>();
    static int binarySearchComparisionCount = 0;
    static int interpolationSearchComparisionCount = 0;

    public static void main(String args[]) {
        try {
            keys = readFile("C:\\workspace\\OCA\\datadfb.txt");
            String[] keysArr = keys.toArray(new String[keys.size()]);

            doQuickSort(keysArr, 0, keys.size() - 1);

            String arr[] = { "Azevedo, Ana", "Silva, Rui", "Boussebough, Imane", "Terracina, Giorgio,",
                    "Lefebvre, Peter", "Houghten, Sher", "Revesz, Peter" };

            System.out.println();

            System.out.printf("Total Elements : %d\n\n", keysArr.length);

            int binaryComplexity = (int) (Math.log(keysArr.length) / Math.log(2));
            int interpolationComplexity = (int) (Math.log(Math.log(keysArr.length) / Math.log(2)) / Math.log(2));
            for (String str : arr) {
                System.out.printf(
                        "Binary Search,        Target: %-20s Index: %-6d Comparision count: %-5d Complexity logn      : %d\n",
                        str, binarySearch(keysArr, str), binarySearchComparisionCount, binaryComplexity);
                System.out.printf(
                        "Interpolation Search, Target: %-20s Index: %-6d Comparision count: %-5d Complexity log(logn) : %d\n",
                        str, interpolationSearch(keysArr, str), interpolationSearchComparisionCount,
                        interpolationComplexity);
                System.out.println();
                binarySearchComparisionCount = 0;
                interpolationSearchComparisionCount = 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile(String filename) throws Exception {
        String line = null;
        List<String> records = new ArrayList<String>();

        // wrap a BufferedReader around FileReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

        // use the readLine method of the BufferedReader to read one line at a time.
        // the readLine method returns null when there is nothing else to read.
        while ((line = bufferedReader.readLine()) != null) {
            records.add(line.trim());
        }

        // close the BufferedReader when we're done
        bufferedReader.close();
        return records;
    }

    private static int binarySearch(String[] sortedArray, String target) {
        return binarySearch(sortedArray, target, 0, sortedArray.length - 1);
    }

    private static int binarySearch(String[] sortedArray, String target, int start, int end) {
        if (start <= end) {
            int mid = -1;
            mid = (start + end) / 2;
            int c = target.compareTo(sortedArray[mid]);
            ++binarySearchComparisionCount;
            return (c == 0) ? mid
                    : (c < 0) ? binarySearch(sortedArray, target, start, mid - 1)
                            : binarySearch(sortedArray, target, mid + 1, end);
        } else {
            return -1;
        }
    }

    static BigDecimal dist(String str1, String str2) {
        int maxlen = str1.length();
        if (str1.length() < str2.length())
            maxlen = str2.length();
        BigDecimal d = BigDecimal.ZERO;
        for (int i = 0; i < maxlen; i++) {
            int dist;
            if (i < str1.length() && i < str2.length()) {
                dist = str1.charAt(i) - str2.charAt(i);
            } else if (i < str1.length()) {
                dist = str1.charAt(i);
            } else {
                dist = -str2.charAt(i);
            }
            d = d.add(new BigDecimal(dist * Math.pow(2, -i * 8)));
        }
        return d;
    }

    public static int interpolationSearch(String[] sortedArray, String toFind) {
        int low = 0;
        int high = sortedArray.length - 1;
        int mid;
        while (sortedArray[low].compareTo(toFind) <= 0 && sortedArray[high].compareTo(toFind) >= 0) {
            if (sortedArray[high].equals(sortedArray[low]))
                return (low + high) / 2;
            // out of range is possible here
            double value = new Double(dist(toFind, sortedArray[low]).doubleValue()) * (high - low);
            mid = (int) (low
                    + (value) / new Double(dist(sortedArray[high], sortedArray[low]).doubleValue()).intValue());
            ++interpolationSearchComparisionCount;
            if (sortedArray[mid].compareTo(toFind) < 0)
                low = mid + 1;
            else if (sortedArray[mid].compareTo(toFind) > 0)
                high = mid - 1;
            else
                return mid;
        }
        if (sortedArray[low].equals(toFind))
            return low;
        // not found
        else
            return binarySearch(sortedArray, toFind);
    }

    public static void doQuickSort(String[] array) {
        doQuickSort(array, 0, array.length - 1);
    }

    public static void doQuickSort(String[] array, int lower, int higher) {
        int i = lower;
        int j = higher;
        String pivot = array[lower + (higher - lower) / 2];
        while (i <= j) {
            while (array[i].compareToIgnoreCase(pivot) < 0) {
                i++;
            }
            while (array[j].compareToIgnoreCase(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                String t = array[i];
                array[i] = array[j];
                array[j] = t;
                i++;
                j--;
            }
        }
        if (lower < j)
            doQuickSort(array, lower, j);
        if (i < higher)
            doQuickSort(array, i, higher);
    }
}
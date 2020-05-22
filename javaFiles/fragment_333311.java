public class Test {
    static int    max;
    static double median;

    static int[]  grades = { 2, 3, 4, 5, 62, 34 };

    public static void main(String args[]) {
        Arrays.sort(grades);

        median();
        getHighest();

        System.out.println(median);
        System.out.println(max);
    }

    public static void median() {

        if (grades.length % 2 == 0) {
            int indexA = (grades.length - 1) / 2;
            int indexB = (grades.length) / 2;

            median = ((double) (grades[indexA] + grades[indexB])) / 2;
        } else {
            int medIndex = (grades.length - 1) / 2;
            median = grades[medIndex];
        }
    }

    public double getMedian() {
        return median;
    }

    public static int getHighest() {
        /* for (int i = 0 ; i < grades.length ; i++) {
         if (grades[i] > max) {
             max = grades[i];
         }
     }*/
     max = grades[grades.length - 1];
     return max;
    }
class findValue {
    public static void main(String args[]) {
        double a[] = new double[6]; //declaration

        a[0] = -3; //initialization
        a[1] = 10;
        a[2] = 5;
        a[3] = 24;
        a[4] = 45.3;
        a[5] = 10.5;

        int n = a.length; //storing length of array
        int temp = 0; //declaring temporary storage place

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {

                if (a[j - 1] > a[j]) {
                    temp = (int)a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp; //bubble sorting
                }
            }
        }
        System.out.println("45.3 found: " + binarySearch(a, 45.3));
    }
    public static int binarySearch(double[] a, double x) {
        int low = 0;
        int high = a.length - 1;
        int mid = (low + high) / 2; //values for binary search

        while (low <= high) {
            mid = (low + high) / 2; //setting value for searching

            if (Double.compare(a[mid], (double)x) < 0) {
                low = mid + 1;
            }
            else if (Double.compare(a[mid], (double)x) > 0) {
                high = mid - 1;
            }
        }
        return mid;
    }
}
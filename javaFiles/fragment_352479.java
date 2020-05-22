class Average {
    /**
     * calculateMean Method
     */
    public static float calculateMean(int[] data) {
        int total = 0;
        for (int index = 0; index < data.length; index++) {
            total += data[index];
        }
        float mean = ((float) total) / data.length;
        return mean;
    }

    /**
     * selectionSort Method
     */

    public static void selectionSort(int[] data) {
        int startScan, index, minIndex, minValue;

        for (startScan = 0; startScan < (data.length - 1); startScan++) {
            minIndex = startScan;
            minValue = data[startScan];
            for (index = startScan + 1; index < data.length; index++) {
                if (data[index] < minValue) {
                    minValue = data[index];
                    minIndex = index;
                }
            }
            data[minIndex] = data[startScan];
            data[startScan] = minValue;
        }
    }
    public static void main(String[] args) {
        int[] data = new int[5];
        Scanner keyboard = new Scanner(System.in);

        for (int index = 0; index < data.length; index++) {
            System.out.println("Enter score #" + (index + 1) + ": ");
            data[index] = keyboard.nextInt();
        }
        selectionSort(data);
        float average = calculateMean(data);
        System.out.println(Arrays.toString(data));
        System.out.println("Average is " + average);
    }
}
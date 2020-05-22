public class TaskCurrency {

    public static void main(String[] args) {
        System.out.println("Enter current exchange rate:");
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        printVertical(convertDollarArray(value), 0);
    }

    public static int[] convertDollarArray(int n) {
        int[] currencyArray = new int[21];
        int[] convertedValue = new int[21];
        for (int i = 1; i < currencyArray.length; i++) {
            currencyArray[i] = i;
            convertedValue[i] = currencyArray[i] * n;
        }
        return convertedValue;
    }

    // New method to print while skipping
    public static void printVertical(int[] arr, int skipIndex) {
        for (int i = 0; i < arr.length; i++)
            if (i == skipIndex) { // Skip the index you want
            } else
                System.out.println(arr[i]); // Or else print the result in a new array
    }

}
public class oddsortSolution {
    public static void main(String args[]) {
        int n[] = { 111, 77, 88, 44, 32, 11, 13, 25, 44 };
        int oddArraySize = 0;        
        for (int i = 0;i < n.length; i++) {
            if (n[i] % 2 != 0) {
                oddArraySize++;
                for (int j = 0; j < oddArraySize; j++) {
                    if (j == oddArraySize - 1) {
                        n[j] = n[i];
                    } else if (n[j] > n[i]) {
                        int temp = n[j];
                        n[j] = n[i];
                        n[i] = temp;
                    }
                }
            }
        }
        int[] oddArray = Arrays.copyOfRange(n, 0, oddArraySize);
        System.out.println( Arrays.toString( oddArray ));
    }
}
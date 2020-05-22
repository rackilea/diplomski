public class SOTest {
    public static void main(String[] args) {
        // create scanner object
        Scanner scanner = new Scanner(System.in);
        // create an array of 10 integers
        int a[] = new int[10];
        for(int i=0;i<10;i++){
            int j = scanner.nextInt();
            // store it in array as incremented by 1.
            a[i]=j+1;
        }
        // Now array of integers have the user input value+1.
        for(int i=0;i<10;i++) {
            System.out.println(" "+ a[i]);
        }
    }
}
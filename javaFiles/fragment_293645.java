public class IsItPrime{
 //main method

public static void main(String[] args) {
//Scanner
    Scanner input = new Scanner(System.in);
    System.out.println("Enter length of array: ");
    int n = input.nextInt();
    int[] numbers = new int[n];
    System.out.println("Enter " + n + " integers to fill the array: ");
    for (int i = 0; i < n; i++) {
        numbers[i] = input.nextInt();
    }
    System.out.println(Arrays.toString(numbers));
    for (int j = 0; j < n; j++) {
        System.out.println(numbers[j] + ": " + j + " -- " + isPrime(numbers[j]));
    }
}

public static boolean isPrime(int numbers) {
    boolean Prime = true; 
    if (numbers == 1 || numbers == 0) {
        Prime = false;
        return Prime;
    }

    for (int i = 2; i < numbers; i++) {

        if (numbers % i == 0) {
            Prime = false;
            return Prime;
        } else {
            Prime = true;
        }

    }

    return Prime;
}
}
public class PrimeDemo {
public static void main(String[] args) {

    int[] test = new int[200];
    Arrays.fill(test, 10);

   // print(numbers);
    System.out.println();
    print(primeReplace(test));


}

public static void print(int[] a) {
    for(int i = 0; i < a.length; i++) {
        System.out.print(a[i] + " ");
    }
}

public static int[] primeReplace(int[] a) {

    System.out.println("Prime: ");

    for(int i = 0; i < a.length; i++)
    {
            if(isPrime(i))
            {
                a[i] = -1;
            }
    }
    return a;

}

private static boolean isPrime(int a) {
    if (a< 2) return false;
    if (a== 2) return true;
    if (a% 2 == 0) return false;
    for (int i = 3; i * i <= a; i += 2)
        if (a % i == 0) return false;
    return true;
}
}
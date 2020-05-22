// completes in O(ln N) time.
public static void main(String args[])  {
    Scanner sc = new Scanner(System.in);
    System.out.print("Factorial of which number: ");
    long num = sc.nextLong();
    long zeros = 0;
    do {
        num /= 5;
        zeros += num;
    } while(num > 0);
    System.out.println("The number of trailing zero is " + zeros);
}
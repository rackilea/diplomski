public class H {

public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.println("Input x: ");
    int x = input.nextInt();

    int i = 0;
    while ( printFib(i) <= x ) {
        System.out.print(printFib(i) + " "); 
        i ++ ;
    }
}

public static int printFib(int number) {
    if (number == 0 || number == 1)
        return number;
    else
        return printFib(number - 1) + printFib(number - 2);
}

}
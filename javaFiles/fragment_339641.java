public class test {
    public static void main(String a1[]) {
        int digit = 1234;
        printData(digit);

    }

    public static void printData(int number) {
        if (number == 0)
            return;
        int remainder = number % 10;
        number = number / 10;
        printData(number);
        System.out.println(remainder);

    }

}
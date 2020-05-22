package hello;

public class Abc {
public static void main(String[] args) {
    int n, sum, temp, remainder, digits;

    int start = 100;
    int end = 999;

    for (int i = start; i <= end; i++) {

        sum = 0;
        digits = 0;

        temp = i;

        // Count number of digits

        while (temp != 0) {
            digits++;
            temp = temp / 10;
        }

        temp = i;

        while (temp != 0) {
            remainder = temp % 10;
            sum = sum + power(remainder, digits);
            temp = temp / 10;
        }

        if (i == sum)
            System.out.println(i + " is an Armstrong number.");

    }
}

static int power(int n, int r) {
    int c, p = 1;

    for (c = 1; c <= r; c++)
        p = p * n;

    return p;
}

}
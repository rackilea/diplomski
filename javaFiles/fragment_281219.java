import java.util.Random;

public class rndNumberGenerator {

    public static int[] myNumbers = new int[] {1, 2, 3, 4, 6, 7, 9};

    public static void main(String[] args) {

        checkNumber1();    

    }

    public static void checkNumber1() {

        Random rnd = new Random();

        int x = rnd.nextInt(10);

        int y = goThroughAnArray1(0, x);

        if (y != -1) {
            System.out.println("Generated number is " + x + " and it's already part of the array."
                   + "\nGenerating new random number..");
           checkNumber2();
        }

        System.out.println("Generated number is " + x + " and it's not the part of the array.");
        System.exit(0);

    }

    public static void checkNumber2() {

        Random rnd = new Random();

        int x = rnd.nextInt(10);

        int y = goThroughAnArray1(0, x);

        if (y != -1) {
            System.out.println("Generated number is " + x + " and it's already part of the array."
                   + "\nGenerating new random number..");
           checkNumber1();
        }

        System.out.println("Generated number is " + x + " and it's not the part of the array.");
        System.exit(0);

    }

    public static int goThroughAnArray1(int i, int number) {

        if (i == myNumbers.length)
            return -1;

        if (myNumbers[i] == number)
            return number;

        i++;
        int x = goThroughAnArray2(i, number);

        return x;
    }

    public static int goThroughAnArray2(int i, int number) {

        if (i == myNumbers.length)
            return -1;

        if (myNumbers[i] == number)
            return number;

        i++;
        int x = goThroughAnArray1(i, number);

        return x;
    }

}
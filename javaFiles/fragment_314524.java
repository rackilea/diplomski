import java.util.Random;


public class RandomMath {

    public static void main(String[] args) {
        int new4Digit = loop(10);
        System.out.println(new4Digit);
    }

    public static int loop(int times){
        int new4Digit = 0;
        for(int i=0; i< times; i++) {
            new4Digit = generator(new4Digit);
            new4Digit = subtraction(new4Digit);
        }
        return new4Digit;
    }

    //create method for generating random numbers
    public static int generator(int new4Digit){
        ...
        return n;
    }
    //method for denoting the bigger number
    public static int bigger(int generated){
        ...
        return big;
    }
    //denoting the smaller number by simply reversing the bigger
    public static int smaller(int bigger){
        ...
        return small;
    }
    //method for subtracting the smaller number from the bigger
    public static int subtraction(int generated){
        int bigger  =  bigger(generated);
        int newNumber = bigger - smaller(bigger);
        return newNumber;
    }
}
public class Even {

public static void main(String args[]) {

    int number = 1;
    int remainder;

    while(number <= 100) {
        number++;
        remainder = number % 2;
        if(remainder == 0) {
            System.out.println(number);
        }
    }

}

}
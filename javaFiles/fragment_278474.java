import java.util.Scanner;

public class BaseConversion {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String theValue;
        String newNum;
        int initialBase;
        int finalBase;
        String[] parts = args;
        if (parts.length > 0) {
            theValue = parts[0];
            isValidInteger(theValue);
            initialBase = Integer.parseInt(parts[1]);
            finalBase= Integer.parseInt(parts[2]);
            isValidBase(finalBase);
       }
       else {
            System.out.println("Please enter a value: ");
            theValue = s.nextLine();
            isValidInteger(theValue);
            System.out.println("Please enter original base: ");
            initialBase = s.nextInt();
            System.out.println("Please enter new base: ");
            finalBase = s.nextInt();
            isValidBase(finalBase);
       }
        // check it
       // isValidInteger(theValue, finalBase);
        s.close();
        newNum = convertInteger(theValue, initialBase, finalBase);


        System.out.println("new number: " + newNum);
    }

    public static void isValidBase(int finalBase) {
        if (finalBase < 2 || finalBase > 36) {
            System.out.println("Error: Base must be greater than or equal to 2 & less than or equal to 36");
            System.exit(1);
        }
    }

    public static void isValidInteger(String num) {
        char chDigit;
        num = num.toUpperCase();
        for(int d = 0; d < num.length(); d++) {
            chDigit = num.charAt(d);
            if (!Character.isLetter(chDigit) && !Character.isDigit(chDigit)) {
                //System.out.println(chDigit);
                System.out.println("Error character is not a letter or number");
                System.exit(1);
            }
        }
    }

    public static String convertInteger(String theValue, int initialBase, int finalBase) {

        double val = 0;
        double decDigit = 0;
        char chDigit;


        // loop through each digit of the original number
        int L = theValue.length();
        for(int p = 0; p < L; p++) {

            // get the digit character (0-9, A-Z)
            chDigit = Character.toUpperCase(theValue.charAt(L-1-p));

            // get the decimal value of our character
            if(Character.isLetter(chDigit)) {
                decDigit = chDigit - 'A' + 10;
            }
            else if (Character.isDigit(chDigit)) {
                decDigit = chDigit - '0';
            }
            else {
                System.out.println("Error d");
                System.exit(1);
            }
            // add value to total
            val += decDigit * Math.pow(initialBase, p);
        }

        // determine number of digits in new base
        int D = 1;

        for( ; Math.pow(finalBase, D) <= val; D++) {}

        // use char array to hold new digits
        char[] newNum = new char[D];

        double pwr; 
        for(int p = D-1; p >= 0; p--) {

            // calculate the digit for this power of newBase
            pwr = Math.pow(finalBase, p);

            decDigit = Math.floor(val / pwr);

            val -= decDigit*pwr;

            // store the digit character

            if(decDigit <= 9) {
                newNum[D-1-p] = (char) ('0' + (int)decDigit);
            }
            else {
                newNum[D-1-p] = (char) ('A' + (int)(decDigit - 10));
            }
        }       
        return new String(newNum);
    }
}
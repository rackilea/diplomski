public class Digits {

    public static void main(String[] args) {
        int n;
        n = 0;
        int b;
        b = 0;
        String number;
        number = "";


    String backwards;
        backwards = "";

        for (int x = 9999; x <= 99999; x++) {
            n = x;
            b = x * 4;
            number = Integer.toString(n);
            backwards = Integer.toString(b);

            if (number.charAt(0) == backwards.charAt(4) && number.charAt(1) == backwards.charAt(3)
                    && number.charAt(2) == backwards.charAt(2) && number.charAt(3) == backwards.charAt(1)
                    && number.charAt(4) == backwards.charAt(0)) {
                System.out.println(n);
                break;
            }
        }
    }
}
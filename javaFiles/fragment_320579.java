public class Binary {

    private static int placeValue = 1;

    public static void main(String [] args) {
        Scanner keyboard = new Scanner (System.in);
        System.out.println("Enter Binary Number Please");
        Integer[] digits = getDigits(keyboard.nextInt());
        System.out.println(Arrays.toString(digits));
        System.out.println("Sum: " + getSum(digits));
        keyboard.close();
    }

    public static Integer[] getDigits(int num) {
        List <Integer> digits = new ArrayList <Integer>();
        collectDigits(num, digits);
        return digits.toArray(new Integer[]{});
    }

    private static void collectDigits(int num, List <Integer> digits) {
       if (num/10>0) {
            collectDigits(num/10, digits);
        }
        digits.add(num % 10);
    }

    private static int getSum(Integer[] digits)
    {
        int result = 0;

        for(int i=(digits.length-1); i>=0; i--)
        {
            result += (digits[i] * placeValue);
            placeValue *= 2;
        }

        return result;
    }
}
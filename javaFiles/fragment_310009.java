public class wordReport {

    //determine the length of the string
    public static void stringLength(String inputString) {

        //determine length of said string
        System.out.println("String length is " + inputString.length() + " characters long.");
    }

    //convert the string to uppercase
    public static void convertToUpperCase(String inputString) {

        //upper case
        System.out.println("Look! I can uppercase your string: " + inputString.toUpperCase());

    }

    //count the words in the string
    public static void wordCount(String inputString) {
        String[] wordsArray = inputString.split(" ");
        System.out.println("There are " + wordsArray.length + " words in the string.");

    }

    //count the characters in the string
    public static void charCount(String inputString) {

        System.out.println("There are " + inputString.length() + " characters in the string.");

    }

    //count the occurrences and percentage of the characters in the string
    public static void occurrenceNPercentage(String inputString) {
        char[] capital = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        char[] small = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int[] count = new int[26];
        char[] chars = inputString.toCharArray();
        int myTotal = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < 26; j++) {
                if (chars[i] == capital[j] || chars[i] == small[j]) {
                    count[j]++;
                    myTotal = myTotal + 1;
                    break;
                }
            }
        }

        System.out.println("Comlete count");
        for (int i = 0; i < 26; i++) {
            System.out.print(" " + small[i]);
            System.out.print(" " + count[i]);
            if (count[i] > 0) {
                System.out.println(" " + (((float) count[i] / myTotal) * 100) + "%");
            } else {
                System.out.println(" 0%");
            }
            //calculate percentage for the full count
        }
    }

    public static void main(String[] args) {

        System.out.println("Please enter String");

        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        stringLength(inputString);
        convertToUpperCase(inputString);
        wordCount(inputString);
        charCount(inputString);
        occurrenceNPercentage(inputString);

    }

}
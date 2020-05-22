public class Main {
    public static void main(String[] args) {
        System.out.println("Input: 3A5o2n4t => Output : " + runLengthDecoding("3A5o2n4t"));
        System.out.println("Input: 3AA5o2n4t => Output : " + runLengthDecoding("3AA5o2n4t"));
        System.out.println("Input: 10A5o2n4t => Output : " + runLengthDecoding("10A5o2n4t"));
        System.out.println("Input: 10AA5o2n4t => Output : " + runLengthDecoding("10AA5o2n4t"));
        System.out.println("Input: A5o => Output : " + runLengthDecoding("A5o"));
        System.out.println("Input: AB5o => Output : " + runLengthDecoding("AB5o"));
    }

    public static String runLengthDecoding(String str3) {
        String convert = "";
        int number = 0;
        String numberString = "";
        String toBeRepeatedString = "";
        boolean flag = false;
        for (int i = 0; i <= str3.length() - 1; i++) {
            char currentChar = str3.charAt(i);
            if (Character.isDigit(currentChar)) { // true or false, the current character is a digit
                numberString = numberString + currentChar; // store the possible integer
            } else {
                if (i + 1 < str3.length()) {
                    char nextChar = str3.charAt(i + 1); // check if the next char is a digit
                    if (!Character.isDigit(nextChar)) { // if not a digit then append toBeRepeatedString

                        if (i == 0 || i + 1 >= str3.length()) {
                            flag = true;
                        } else {
                            toBeRepeatedString += nextChar;
                            flag = false;
                        }
                    } else {
                        flag = true;
                    }
                }

                if (flag) {
                    toBeRepeatedString += currentChar;

                    // This will accomodate inputs "A3B";
                    if (!numberString.isEmpty()) {
                        number = Integer.parseInt(numberString); // parse the number of repeats
                    } else {
                        number = 1;
                    }

                    numberString = ""; // reset number

                    String temp2 = "";

                    // Repeat the currentChar
                    for (int j = 0; j < number; j++) {
                        temp2 += toBeRepeatedString;
                    }

                    convert = convert + temp2; // store it to the result
                    toBeRepeatedString = ""; // reset toBeRepeatedString
                }

            }

        }
        return convert;
    }

}
public static String toBinary(int number) {
        int remainder;
        String numString = "";

        while (number != 0) {

            //% operator is the modulo sign
            //this returns the remainder of (number / 2)
            remainder = number % 2;

            //divides in java always round down
            //so don't worry about the last number not being 0
            number = number / 2;

            //add the remainder to the leftmost side of the string.
            //notice how this means the Integer.toString comes first
            numString = Integer.toString(remainder) + numString;


            //if you can't use the Integer class 
            //use ("" + some_int) to let Java automatically convert
            //an integer some_int to a String for you e.g.:

            //numString = "" + remainder + numString;
        }

        return numString;
    }
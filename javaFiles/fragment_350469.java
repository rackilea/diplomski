public static void main(String[] args) {
        double x = 999999.99; // thats the max size of the double
        // I dont know how to code this part
        int[] splitD = { 9, 9, 9, 9, 9, 9 }; // the number
        int[] splitDec = { 9, 9 }; // the decimal

        // convert number to String
        String input = x + "";
        // split the number
        String[] split = input.split("\\.");

        String firstPart = split[0];
        char[] charArray1 = firstPart.toCharArray();
        // recreate the array with size equals firstPart length
        splitD = new int[charArray1.length];
        for (int i = 0; i < charArray1.length; i++) {
            // convert char to int
            splitD[i] = Character.getNumericValue(charArray1[i]);
        }

        // the decimal part
        if (split.length > 1) {
            String secondPart = split[1];
            char[] charArray2 = secondPart.toCharArray();
            splitDec = new int[charArray2.length];
            for (int i = 0; i < charArray2.length; i++) {
                // convert char to int
                splitDec[i] = Character.getNumericValue(charArray2[i]);
            }
        }
    }
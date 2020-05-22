public static char[] getDigits(char[] charArray) {    
        int arrayLength = charArray.length;
        char[] toReturnDigits = new char[arrayLength];
        int index = 0;
        for (int i = 0; i < arrayLength; i++) {
            if (parseInt(charArray[i].toString(), 10)) { //assuming you expect base 10 digits
                toReturnDigits[index++] = charArray[i];
            }
        }
        return toReturnDigits;
    }
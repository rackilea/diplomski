// remove everything that is not a digit
    String digitsOnly = binary.replaceAll("[^\\d]","");
    //iterate over every digit
    for(char digit:digitsOnly.toCharArray()) {
        int n = Character.getNumericValue(digit);
        // do stuff...
    }
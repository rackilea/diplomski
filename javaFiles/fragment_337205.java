int convert_from_Roman(String value) {  
    String trimmed = value.trim(); // using the result of trim
    int convertedValue = 0;
    for (int digit = 0; digit < trimmed.length(); digit++) { // < instead <=
        char romanVal = trimmed.charAt(digit);
        for(int roman = 0; roman < romanArr.length; roman++) {
            if (romanArr[roman].equals(String.valueOf(romanVal))) // char char comparison
                convertedValue += arabicArr[roman]; // fixed index
            else
                continue;
        }
    }
    return convertedValue;
}
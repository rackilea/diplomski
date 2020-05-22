for ( i = 0; i < inputToStringArray.length; i++) { 
    try {
        values.add(Double.parseDouble(inputToStringArray[i]));
    } catch (NumberFormatException exp) {
        System.err.println(inputToStringArray[i] + " is not a valid double");
    }
}
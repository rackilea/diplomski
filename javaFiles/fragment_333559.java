1) Multiply fraction by 2 =>  0.625 * 2 = 1.25
    The digit to the left of the decimal point is the first binary value, 0.1 so far
2) Ignore the ones-place digit and you have 0.25 which is still larger than zero.
    Multiply the fraction by 2 => 0.25 * 2 = 0.50
    The digit to the left of the decimal point is the next binary value, 0.10 so far
3) Ignore the ones-place digit and you have 0.50 which is less than zero.
    Multiply the fraction by 2 => 0.5 * 2 = 1.00
    The digit to the left of the decimal point is the next binary value, 0.101 so far
4) Ignore the ones-place digit and you have 0.00 which is equal to zero.
    Conversion complete!

private static String floatToBinaryString( double n ) {
    String val = "0.";    // Setting up string for result
    while ( n > 0 ) {     // While the fraction is greater than zero (not equal or less than zero)
        double r = n * 2;   // Multiply current fraction (n) by 2
        if( r >= 1 ) {      // If the ones-place digit >= 1
            val += "1";       // Concat a "1" to the end of the result string (val)
            n = r - 1;        // Remove the 1 from the current fraction (n)
        }else{              // If the ones-place digit == 0
            val += "0";       // Concat a "0" to the end of the result string (val)
            n = r;            // Set the current fraction (n) to the new fraction
        }
    }
    return val;          // return the string result with all appended binary values
}
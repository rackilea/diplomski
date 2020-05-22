double lowVal, mediumVal, highVal;
String lowString = "1.2", mediumString = "null", highString = "7.9";

lowVal = parseDouble(lowString);
mediumVal = parseDouble(mediumString);
highVal = parseDouble(highString);

double parseDouble(String s) {
    try {
        return Double.parseDouble(s);
    } catch (NumberFormatException e) {
        return Double.NAN;
    } 
}
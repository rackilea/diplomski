Double lowVal;
Double mediumVal;
Double highVal;
String lowString = "1.2", mediumString = "null", highString = "7.9";

lowVal = parseDouble(lowString);
mediumVal = parseDouble(mediumString);
highVal = parseDouble(highString);

Double parseDouble(String s) {
    try {
        return Double.parseDouble(s);
    } catch (NumberFormatException e) {
        return null;
    } 
}
public static double calcFeetAndInchesToCentimetres(double inches) {
    if (inches >= 0){
        double inchesToFeet = inches / 12;
        double inchesRemain = inches - (inchesToFeet * 12);
        return calcFeetAndInchesToCentimetres(inchesToFeet, inchesRemain);
    } else {
        return -1;
    }
}
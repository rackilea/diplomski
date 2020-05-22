private double computeAngles()
{
    double side1 = getSide1_Length(side1);
    double side2 = getSide2_Length(side2);
    double side3 = getSide3_Length(side3);

    int angle2 = Math.acos(((Math.pow(side3,2)) + (Math.pow(side2,2)) - (Math.pow(side1,2)) / (2 * (side3 * side2))));

    return angle2;
}
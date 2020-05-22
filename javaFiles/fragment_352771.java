private static final double GRAMS_PER_POUND = 433.59237;
public static double weight(double sGravity, double weightLbs)  
{
    double roundedSG = sGravity / 10;
    double mass = (weightLbs * GRAMS_PER_POUND)/roundedSG;
    double weight = (mass * roundedSG)/GRAMS_PER_POUND;

    return weight;
}
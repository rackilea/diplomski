public class AnnualFuelUse
{
    //private instance variables
    private double gallonsUsed, pricePerGallon, startingMiles, endingMiles;

    //constructor with two parameters
    AnnualFuelUse(int FillUpNumber, double eMiles, double sMiles, double galsUsed, double pricePerGal)
    {
        startingMiles = sMiles;
        endingMiles = eMiles;
        gallonsUsed = galsUsed;
        pricePerGallon = pricePerGal;
    }

    //getter method to return the value of distance traveled by the object on one trip
    public double getDistance()
    {
        return endingMiles - startingMiles;
    }

    //getter method to return the value of the miles per gallon of the object on one trip
    public double getMPG()
    {
        return getDistance() / gallonsUsed;
    }

    //getter method to return the value of the gallons per mile of the object on one trip
    public double getGPM()
    {

        return gallonsUsed / getDistance();
    }

    //getter method to return the value of the total gasoline purchases on one trip
    public double getTotalCost()
    {
        return pricePerGallon * gallonsUsed;
    }

    //mutator method which calculates the minimum value of a given array
    public static double min(double minMaxVariable[])
    {
        double minVariable = Double.MAX_VALUE;
        for(int i = 0; i < minMaxVariable.length; i ++)
        {
            if((minMaxVariable[i]) < minVariable)
            {    
                minVariable = minMaxVariable[i];
            }
        }
        return minVariable;
    }

    //mutator method which calculates the minimum value of a given array
    public static double max(double minMaxVariable[])
    {
        double maxVariable = Double.MIN_VALUE;
        for(int i = 0; i < minMaxVariable.length; i ++)
        {
            if((minMaxVariable[i]) > maxVariable)
            {
                maxVariable = minMaxVariable[i];
            }
        }
        return maxVariable;
    }

    //mutator method which calculates the total value of a given array
    public static double totalOf(double totalVariable[])
    {
        double totalValue = 0;
        for(double newValue : totalVariable)
        {
            totalValue += newValue;
        }
        return totalValue;
    }
}
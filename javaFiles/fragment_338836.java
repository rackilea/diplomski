/**
Drives a certain amount, consuming gas
@param distance the distance driven
*/
public void drive(double distance)
{
    drive = drive + distance;
    gas = gas - (distance / milesPerGallon);
}

/**
Gets the amount of gas left in the tank.
@return the amount of gas
*/

public double getGas()
{
    return gas;
}
public int howManyAreRearWheelDrive()
{
    int i = 0;
    Iterator<Lamborghini> rear = inventory.iterator();
    while(rear.hasNext()){
        Lamborghini nextLamb = rear.next();

        if(nextLamb.getIsRearWheelDrive ()) // this is a method .equals(true))

        {               
            // int rearHold = nextLamb.getIsRearWheelDrive();
            // why cast this to an local int??
            i++;
        }  
        // return rearHold;
        // readHold is not in scope here
        // if you return here, the while loop will not complete
        // the variable i is hold the value you want
    }

//Lamborghini class
public boolean getIsRearWheelDrive()
{
    return isRearWheelDrive;
}
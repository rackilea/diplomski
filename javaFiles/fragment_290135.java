@Override
public String toString()
{
    String str = "not Streaming";
    //check whether the name is G200 or not.
    if(getName().equals("G200"))
        str="Streaming";

    return ("\n Name: " + getName() +
            "\n No of pixels: " + getNoOfDisplayPixels() + 
            "\n Width: " + getWidth() +
            "\n Height: " + getHeight() +
            "\n Weight: " + getWeight() +
            "\n Powered On: " + getIsPoweredOn() +
            "\n Recharging: " + getIsRecharging() +
            "\n Streaming: " +str  // Don't want to use get
    );
}
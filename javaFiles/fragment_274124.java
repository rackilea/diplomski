public class DistributeBot extends RobotSE
{
    private int size;

    //note that although you can't see it unless you scroll to the right
    //the constructor now has 'int size' as the last parameter
    public DistributeBot(City aCity, int aStreet, int anAvenue, Direction aDirection, int numThings, int size) 
    { 
        super(aCity, aStreet, anAvenue, aDirection, numThings); 

        //you technically DON'T have to do this next line if you 
        //don't create the attribute 'size' for this class but you 
        //probably should. It's hard to tell from your description.

        this.setSize(size); 

        //notice how below I use 'this.size' because this 
        //object officially has an attribute called size

        this.putThings(this.size);

        ...

        //anything else you want to do in the constructor 
        //you can put the functionality of putThings in here if you want
    }

   ...

    private int getSize()
    {
        return this.size;
    }
    private void setSize(int size)
    {
        this.size = size;
    }
}
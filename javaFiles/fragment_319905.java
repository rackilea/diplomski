public class DeskPhone extends Phone
{
    public boolean connected;
    // Here we declade voltage as field
    public Voltage voltage; 

    protected DeskPhone(String modelArg, Dimensions dimenstion, Voltage voltage) //enum as parameter
    {
        super(modelArg, dimenstion);
        // Here we set field value
        this.voltate = voltage;
    }
  ...
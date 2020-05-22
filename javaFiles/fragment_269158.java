public class Car
{
    public enum Transmission
    {
        Drive, Park, Reverse
    }

    private Transmission transmission;

    public void setTransmission( Transmission transmission )
    {
        this.transmission = transmission;
    }

    public String getTransmission()
    {
        return String.format( "The car is currently in %s", transmission );
    }
}
public class Car
{
    private final String[] transmission = { "Drive", "Park", "Reverse" };

    private final Scanner  input;

    private int            index;

    public Car( Scanner input )
    {
        this.input = input;
    }

    public void setTransmission()
    {
        System.out.println( "To change the transmission, enter D for Drive,P for Park or R for reverse" );
        switch ( input.nextLine() )
        {
        case "D":
        case "d":
            System.out.println( "The Car is currently in Drive." );
            index = 0;
            break;
        case "P":
        case "p":
            System.out.println( "The Car is currently in Park." );
            index = 1;
            break;
        case "R":
        case "r":
            System.out.println( "The Car is currently in Reverse" );
            index = 2;
            break;
        }
    }

    public String getTransmission()
    {
        return String.format( "The car is currently in %s", transmission[index] );
    }
}
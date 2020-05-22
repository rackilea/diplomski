public class CarApplication
{
    public static void main( String[] args )
    {
        try ( Scanner input = new Scanner( System.in ) )
        {
            System.out.println( "To change the transmission, enter D for Drive,P for Park or R for reverse" );
            String answer = input.nextLine();
            Transmission transmission = parseTransmission( answer );

            Car car = new Car();

            car.setTransmission( transmission );

            System.out.println( car.getTransmission() );
        }
    }

    private static Transmission parseTransmission( String input )
    {
        switch ( input )
        {
        case "D":
        case "d":
            return Transmission.Drive;
        case "P":
        case "p":
            return Transmission.Park;
        case "R":
        case "r":
            return Transmission.Reverse;
        default:
            throw new IllegalArgumentException( "expected an input D,P,R but got: " + input );
        }
    }
}
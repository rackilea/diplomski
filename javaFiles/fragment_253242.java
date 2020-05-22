public static void main(String[] args)
{
    try
    {
        // what can i write in here to make this a valid exception?
        String model = Customer("myModel");
    }
    catch (InvalidCar e)
    {
        System.err.println("test");
    }
}
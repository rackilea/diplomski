public class ApartmentComplex
{
    public static void main(String[] args)
    {
        int numWindowsPerRoom = 3;
        int desiredWindowHeight = 10;
        int desiredWindowWidth = 10;

        int numRooms = 5;
        Apartment aptWithFiveRooms = new Apartment(numRooms, numWindowsPerRoom, desiredWindowHeight, desiredWindowWidth);

        WindowOrder singleSingleOrder = apt.orderForOneUnit();
        List<WindowOrder> allRoomsOrder = apt.orderForAllUnits();

        numRooms = 3;
        Apartment aptWithThreeRooms = new Apartment(numRooms, numWindowsPerRoom, desiredWindowHeight, desiredWindowWidth);
        List<WindowOrder> threeRoomsOrder = apt.orderForAllUnits();
    }
}
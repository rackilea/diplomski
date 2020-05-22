/**
 * All apartment rooms have the same number of windows, with the
 * same size window for each of those.
 */
public class Apartment
{
    private int numRooms_;
    private int windowsPerRoom_;
    private Window window_;

    /**
     * Constructor
     */
    public Apartment(numRooms, windowsPerRoom, desiredWindowHeight, desiredWindowLength)
    {
        numRooms_ = numRooms;
        windowsPerRoom_ = windowsPerRoom;
        window_ = new Window(desiredWindowHeight, desiredWindowLenght);
    }

    /** 
     * Orders for one room in apartment
     */
    public WindowOrder orderForOneUnit() 
    {
        WindowOrder order = new WindowOrder(window_, 1);

        return order;
    }

    /** 
     * Orders for all rooms in apartment
     */
    public List<WindowOrder> orderForAllUnits() 
    {
        List<WindowOrder> orders = new ArrayList<WindowOrder>();

        WindowOrder order;
        for(i=0; i<numRooms_; i++)
        {
            orders.add(new WindowOrder(window_, windowsPerRoom_);
        }
        return orders;
    }
}
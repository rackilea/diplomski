public Seat findSeat(String serviceClass, String preference)
{
    if(serviceClass.equals("VIP"))
    {
        return findSeatIn(VIP, preference);
    }
    else if(serviceClass.equals("Regular"))
    {
        return findSeatIn(Regular, preference);
    }
}

public Seat findSeatIn(Seat[][] seatArray, String preference)
{
     // query seatArray for preference
}
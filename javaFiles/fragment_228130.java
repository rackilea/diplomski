class Pump
{
    constant int PRICE_PER_LITRE = 100; //in pence

    private int litresDispensed;
    private bool nozzleUp;
    private int litresAvailable;
    private int price; //in pence

    construct()
    {
        litresDispensed = 0;
        nozzleUp = false;
    }

    startFuelling()
    {
        nozzleUp = true;
    }

    stopFuelling()
    {
        nozzleUp = false;
    }

    takeFuel(int litresTaken)
    {
        if(nozzleUp = true)
        {
            litresAvailable -= litresTaken;
            price += litresTaken * PRICE_PER_LITRE;
        }
        else
        {
            error("You must lift the nozzle before taking fuel!");
        }
    }

    getPrice()
    {
        if(nozzleUp = true)
        {
            error("You can't pay until you've finished fuelling! Please return the nozzle");
        }
        else
        {
            return price;
        }
    }
}
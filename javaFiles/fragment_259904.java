public static CarParkDb getInstance(Context c) // <-- added context as parameter
{
    synchronized(CarParkDb.class)
    {
        if (instance == null)
        {
            instance = new CarParkDb(c); // <-- used context in constructor
        }   
        return instance;
    }
}
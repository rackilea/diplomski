public class Traka<T extends Vozilo> extends Thread
{
    protected int vrijemeRada;
    ...

    private Class<T> type;

    public Traka(Class<T> type) {
        this.type = type;
    }

    @Override
    public void run()
    {
        while(true)
        {
            T newInstance = type.newInstace(); // this uses the default constructor
        }
    }
}
public interface TableDbCallBack extends Runnable {}

public class HouseTableDb implements TableDbCallBack
{
    @Override
    public void run()
    {
         // Whatever it should do   
    }
} 

public class AdminTableDb implements TableDbCallBack
{
    @Override
    public void run()
    {
         // Whatever it should do   
    }
}
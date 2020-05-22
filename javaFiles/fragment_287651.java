public class MyWidget() extends AbstractWidget
{

    public MyWidget()
    {
        this.service. = new MyService();
    }

    private class MyService extends Service<Void>
    {
        protected Task<Void> createTask()
        {
            @Override
            return new Task<Void>()
            {
                // whatever
            }
        }
    }
}
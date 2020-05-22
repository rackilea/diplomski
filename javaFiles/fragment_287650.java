public abstract class AbstractWidget extends Whatever
{
    protected Service<?> service;

    public AbstractWidget()
    {
    }

    public void start()
    {
        service.start();
    }

    public void stop()
    {
        service.cancel();
        service.reset();
    }
}
public class ExampleThread implements Runnable
{
    private SomeBean someBean;

    public ExampleThread()
    {
        this.someBean = CDI.current().select(SomeBean.class).get();
    }

    @Override
    public void run() {
        someBean.do();
    }
}
public class MyApplication extends UI
{

    @Override
    protected void init(VaadinRequest request) 
    {
        addWindow(new ModalWindow());
    }
}
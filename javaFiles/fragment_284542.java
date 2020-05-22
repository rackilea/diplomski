@ViewDocking(...)
public class DetailsPane extends SomeNode implements ActiveContextSensitive, LocalContextProvider {

    private final SimpleContextContent contextContent = new SimpleContextContent();
    private final SimpleContext context = new SimpleContext(contextContent);
    private Context activeContext;
    private MyPojo myPojo;

    ...

    @Override
    public Context getLocalContext() {
        return context;
    }

    @Override
    public void setActiveContext(Context activeContext) {
        this.activeContext = activeContext;
        this.activeContext.addContextListener(MyPojo.class, (ContextEvent event) -> contextChanged());
        contextChanged();
    }

    private void contextChanged() {
        MyPojo newMyPojo = activeContext.find(MyPojo.class);
        if ((myPojo == null && newMyPojo != null) || (myPojo null && !sample.equals(newMyPojo))) {
            if (myPojo != null) {
                unregister();
            }
            myPojo = newMyPojo;
            if (myPojo != null) {
                register();
            }
        }
    }

    private void unregister() {
        contextContent.remove(myPojo);

        //reset DetailsView
    }

    private void register() {
        // configure DetailsView

        contextContent.add(myPojo);
    }
...
}
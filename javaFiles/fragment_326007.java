public class ClockWidget extends Widget implements TimeoutListener, DummyInterface {

    private ArrayList<ActivityListeners> activityListeners;

    public ClockWidget() {
        super();
        System.out.println("ClockWidget constructor.");
        lookupActivityListeners();
    }

    @Override
    public String getWidgetName() {
        return "Clock widget";
    }

    @Override
    public void onTimeout() {
        System.out.println("Timeout!");
    }

    @Override
    public void dummyMethod() {
        // Does nothing.
    }

    private void lookupActivityListeners() {

        activityListeners = new ArrayList<>();

        try {
            BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext(); 
            Collection<ServiceReference<ActivityListener>> serviceReferences = context.getServiceReferences(ActivityListener.class, null);

            for (ServiceReference<ActivityListener> serviceReference : serviceReferences) {
                ActivityListener activityListener = (ActivityListener) context.getService(serviceReference);
                if (activityListener != null) {
                    activityListeners.add(activityListener);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
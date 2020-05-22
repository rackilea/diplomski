public class DaggerWrapper {

    private static MainComponent mComponent;

    public static MainComponent getComponent() {
        if (mComponent == null) {
            initComponent();
        }
        return mComponent;
    }

    private static void initComponent () {
       mComponent = DaggerMainComponent
                .builder()
                .utilModule(new ModuleUtil())
                .build();
    }
}
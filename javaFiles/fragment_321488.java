public class GluonApplication extends MobileApplication {

    public static final String PRIMARY_VIEW = HOME_VIEW;
    public static final String SECONDARY_VIEW = "Secondary View";
    private SocketConnection socketConnection;
    private View primaryView; // Add
    private View secondaryView; // Add

    @Override
    public void init() {
        primaryView = new PrimaryView().getView();
        secondaryView = new SecondaryView().getView();
        addViewFactory(PRIMARY_VIEW, () -> primaryView);
        addViewFactory(SECONDARY_VIEW, () -> secondaryView);
        DrawerManager.buildDrawer(this);

        /*
         * This will start the socket connection
         */
        socketConnection = new SocketConnection(primaryView, secondaryView);
        socketConnection.start();
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.GREEN.assignTo(scene);

        scene.getStylesheets().add(GluonApplication.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(GluonApplication.class.getResourceAsStream("/icon2.png")));


    }
}
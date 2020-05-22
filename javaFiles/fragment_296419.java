class TariffModelManager {
    private static final TariffModelManager tariffModelManager = _instance;
    private static volatile TariffModelManager _instance = new TariffModelManager();

    private TariffModelManager() {
        System.out.println("From Constructor: " + this);
    }

    public static TariffModelManager getInstance() {
       return _instance;
    }
}
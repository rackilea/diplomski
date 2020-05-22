class TariffModelManager {
    private static final TariffModelManager tariffModelManager = TariffModelManager.getInstance();
    private static volatile TariffModelManager _instance = new TariffModelManager();

    private TariffModelManager() {
        System.out.println("From Constructor: " + this);
    }

    public static TariffModelManager getInstance() {
        if (_instance == null) {
            synchronized (TariffModelManager.class) {
                if (_instance == null) {
                    _instance = new TariffModelManager();
                    System.out.println("Creating new instance: " + _instance);
                }
            }
        }
        return _instance;
    }

    public static void main(String[] args) {
        TariffModelManager.getInstance();

        System.out.println("tariffModelManager: " + TariffModelManager.tariffModelManager);
        System.out.println("_instance: " + TariffModelManager._instance);
    }
}
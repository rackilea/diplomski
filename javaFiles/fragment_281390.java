public final class ServiceFactory {

    public static DBAccessService getDBAccessService() {
        DBAccessService service = new DBAccessServiceImpl();
        return service;
    }
}
public class BusinessLogic {
    @Inject
    private ServiceClientAdapter serviceClientAdapter;

    @Inject
    private Map<String, ServiceClientAdapter> mapBinder;

    public void setupAndUseClientAdapter() {
        String userType = getUserTypeFromLdapServer();
        serviceClientAdapter = mapBinder.get(userType);
        if (serviceClientAdapter == null) {
            throw new IllegalArgumentException(
                    "No service client adapter available for " +
                    userType + " user type.";
        }
        doStuffWithServiceClientAdapter();
    }
}
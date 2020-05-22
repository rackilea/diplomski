public class JdkVersionService {

    @Inject
    private JdkVersionWebService jdkVersionWebService;

    // No need to check too often. Once a year will be good :) 
    private final Supplier<JdkVersion> latestJdkVersionCache
            = Suppliers.memoizeWithExpiration(jdkVersionSupplier(), 365, TimeUnit.DAYS);


    public JdkVersion getLatestJdkVersion() {
        return latestJdkVersionCache.get();
    }

    private Supplier<JdkVersion> jdkVersionSupplier() {
        return new Supplier<JdkVersion>() {
            public JdkVersion get() {
                return jdkVersionWebService.checkLatestJdkVersion();
            }
        };
    }
}
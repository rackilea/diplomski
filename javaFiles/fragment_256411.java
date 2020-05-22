public class SSLConfig {
    private static final String PROD_INSTANCE = "Prod";
    private static final String STG_INSTANCE1 = "Staging";
    private static final String STG_INSTANCE2 = "Stg";
    private static final String QA_INSTANCE = "QA";
    private static final String DEV_INSTANCE = "DEV";

    private static HostnameVerifier getHostnameVerifierForInstance(String instance,
                                                                   String enabled){
        return Boolean.parseBoolean(enabled)&&reject(instance) ? denyAll() 
                : permitAll();
    }

    private static boolean reject(String instance) {
        return rejections().anyMatch(instance.trim().toLowerCase()::startsWith);
    }

    private static Stream<String> rejections() {
        return Stream.of(PROD_INSTANCE, STG_INSTANCE1,
                STG_INSTANCE2, QA_INSTANCE, DEV_INSTANCE).map(String::toLowerCase);
    }

    private static HostnameVerifier denyAll() {
        return (hostname, session) -> false;
    }

    private static HostnameVerifier permitAll() {
        return (hostname, session) -> true;
    }
}
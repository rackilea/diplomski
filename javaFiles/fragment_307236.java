public static void main(String[] args) {
    System.setProperty("sun.security.ssl.allowUnsafeRenegotiation","true"); // for non prod systems
    SpringApplication.run(Application.class, args);
}
@Bean
CommandLineRunner init() {
    def customHttpsSSLConfig = new CustomHttpsSSLConfig();
    customHttpsSSLConfig.init(instance,hostnameVerification,trustweaverKeystore, trustweaverKeystoreType, trustweaverKeystorePassword, trustweaverCATrustStore, trustweaverCATrustStoreType, trustweaverCATrustStorePassword);
}
public class SecurityProvider {

    public SecurityProvider() {
       if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
          Security.addProvider(new BouncyCastleProvider());
       }
}
@ExtendWith(DropwizardExtensionsSupport.class)
public class MyTest {

    public static final DropwizardAppExtension<Config> app = new DropwizardAppExtension<>(MyApp.class);

    ...

       // app.getLocalPort() is also available

}
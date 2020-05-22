@RunWith(Arquillian.class)
public class ArquillianTest {
    private static final String[] DEPENDENCIES = {
        "org.aspectj:aspectjrt:1.8.7"
    };

    @Deployment
    public static JavaArchive createEnvironement() {
        JavaArchive lib = ShrinkWrap.create(JavaArchive.class, "libs.jar");
        for (String dependency : DEPENDENCIES) {
            lib.merge(Maven.resolver().resolve(dependency).withTransitivity().asSingle(JavaArchive.class));
        }

        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
            // create you deployment here
            .as(JavaArchive.class);

        JavaArchive toBeDeployed = jar.merge(lib);

        return toBeDeployed;
    }

    // other stuff, like tests

}
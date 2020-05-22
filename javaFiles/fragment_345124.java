@RunsWith(Arquillian.class)
public class MyArquillianTest {
    @Deployment
    public Archive<?> createDeployment() { ... }

    @Test
    public void shouldBeAbleToReadSysPropAtStartup() {
        Assert.assertTrue(System.getProperty("log.level") != null);
    }
}
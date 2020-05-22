@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestAppConfig.class } )
public class TestVcheckResourceJersey extends AbstractSpring3JerseyTest {


    @Inject
    IVcheckProvider vcheckProvider;

    @Test
    public void testCheckNpanxx() throws ProviderException {
        Assert.assertNotNull(vcheckProvider);
    }
}
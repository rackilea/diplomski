@RunWith(Arquillian.class)
@RunAsClient
public class TrickerResourceTest {
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
            .addPackage(Tricker.class.getPackage(), TrickerType.class.getPackage())
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

     @Test
      public void getAllTrickers() throws Exception
      {
         Assert.assertTrue(true);
      }

}
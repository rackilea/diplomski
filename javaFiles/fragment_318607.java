@RunWith(Arquillian.class)
public class TestA {

   @Deployment(name = "x", managed = false) @TargetsContainer("manual_felix")
   public static Archive<?> deployment() {
      return ShrinkWrap.create....
   }

   @ArquillianResource
   private ContainerController cc;

   @ArquillianResource
   private Deployer d;


   @Test @InSequence(1)
   public void start() {
      cc.start("manual_felix", new Config().add("frameworkProperties", "my-custom-properties-file"));
      d.deploy("x");
   }

   @Test @InSequence(2) @OperatesOnDeployment("x")
   public void shouldDoSomethingInsideX() {
       // executes inside container in context of X
   }
}
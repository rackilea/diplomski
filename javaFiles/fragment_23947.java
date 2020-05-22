@ManagedBean
@EJBs({
   @EJB(name="helloworld.HelloBean", type=SampleService.class)
   // ... etc
})
public class ResourceProducerBean { }
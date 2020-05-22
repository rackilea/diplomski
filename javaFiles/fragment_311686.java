@Component(immediate=true)
@Instantiate
public class Controller {

    @Requires(filter="(factory.name=A)")
    Factory factoryOfA;

    @Requires(filter="(factory.name=B)")
    Factory factoryOfB;    

    ComponentInstance instance;

    @Validate
    public void createA() throws Exception {
        instance = factoryOfA.createInstance(null);
    }

    public void switchToB() throws Exception {
        instance.dispose();
        instance = factoryOfB.createInstance(null);
    }
}
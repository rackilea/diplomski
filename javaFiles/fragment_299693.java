public class App {

  public static void main(String[] args) {
    runGuice();

  }

  private static void runGuice() {
    Log localLogger = LogFactory.getLog(App.class);

    ProductionInjectModule pm = new ProductionInjectModule(localLogger);
    Injector injector = Guice.createInjector(pm);

    IVehicle veh = injector.getInstance(IVehicle.class);
    int wc = veh.getWheelCount();

    IAnimal amh = injector.getInstance(IAnimal.class);
    amh.makeNoise();
  }

 }




import com.google.inject.AbstractModule;
import com.google.inject.Module;

public class ProductionInjectModule extends AbstractModule implements Module {

  private final org.apache.commons.logging.Log Logger;

  public ProductionInjectModule(org.apache.commons.logging.Log concreteLogger) {
    this.Logger = concreteLogger;
  }

  @Override
  protected void configure() {
    try {
      bind(org.apache.commons.logging.Log.class).toInstance(this.Logger);
      bind(IVehicle.class).toConstructor(Car.class.getConstructor(org.apache.commons.logging.Log.class));
      bind(IAnimal.class).toConstructor(Dog.class.getConstructor(org.apache.commons.logging.Log.class));
    } catch (NoSuchMethodException e) {
      addError(e);
    }
  }

}
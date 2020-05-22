public class YourModule extends AbstractModule {
    protected void configure() {
      Multibinder<Vehicle> multibinder
         = Multibinder.newSetBinder(binder(), Vehicle.class);
      multibinder.addBinding().to(Buick.class);
      multibinder.addBinding().to(Chevy.class);
      multibinder.addBinding().to(Ferrari.class);
   }
 }

 public class YourInterestingClass {
   private final Set<Vehicle> vehicles;

   @Inject
   public YourInterestingClass(Set<Vehicles> vehicles){
     this.vehicles = vehicles;
   }

   public void doSomethingWithVehicles(){
     for(Vehicle vehicle: vehicles){
       // do something
     }
   }
 }
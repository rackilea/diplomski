@Component(modules = {
     AppModule.class,
     NetModule.class,
     ThirdModule.class // module without constructor
 })
 public interface NetComponent{
     // ...
 }
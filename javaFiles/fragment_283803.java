@Component
@Scope(SCOPE_PROTOTYPE)
public class ServiceA<S> {
  private final ServiceB<S,String> dependentServiceB;

  public ServiceA (@Qualifier("serviceBWithInt")ServiceB<S,String> dependentServiceB){
     this.dependentServiceB = dependentServiceB;
  }
}
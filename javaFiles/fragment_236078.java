public class Foo{

  void onEvent(Event e){ ... }

} 

public interface Event{
     Object[] getArgs();

     //other Event specific methods
     ...
}
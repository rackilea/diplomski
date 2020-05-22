@Component
@Scope("session")
public class MyStringProvider implements Provider<String> {

   private String value = "something";

   public String get() {
       return this.value;
   }
}
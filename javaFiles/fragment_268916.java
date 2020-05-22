// The qualifier for the production/qa/unit test 
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD,
 ElementType.FIELD, ElementType.PARAMETER})
public @interface Stage {
   String value() default "production";
}

// The interface for the stage-dependant service
public interface Greeting{
    public String sayHello();
}

// The production service
@Stage("production")
public class ProductionGreeting implements Greeting{
    public String sayHello(){return "Hello customer"; }
}

// The QA service
@Stage("qa")
public class QAGreeting implements Greeting{
    public String sayHello(){return "Hello tester"; }
}

// The common code wich uses the service
@Stateless
public class Salutation{
   @Inject Greeting greeting; 
   public String sayHello(){ return greeting.sayHello(); };
}

// The dynamic producer
public class GreetingFactory{
    @Inject
    @Any
    Instance<Greeting> greetings;        

    public String getEnvironment(){
         return System.getProperty("deployenv");
    }

    @Produces
    public Greeting getGreeting(){
        Instance<Greeting> found=greetings.select(
           new StageQualifier(getEnvironment()));
        if (!found.isUnsatisfied() && !found.isAmbiguous()){
           return found.get();
        }
        throw new RuntimeException("Error ...");
    }

    public static class StageQualifier 
      extends AnnotationLiteral<Stage> 
      implements Stage {
       private String value;

       public StageQualifier(String value){
           this.value=value;
       }
       public String value() { return value; }
     }

}
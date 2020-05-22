@ManagedBean( name = "someClass" )
public class SomeClass {

    boolean annotated = false;

    public boolean isAnnotated(){
        return annotated;
    }

    @PostConstruct
    public void postConstruct(){
        if (inspect(this.getClass().getMethod("someMethod")){
            annotated=true;
        }
    }

}
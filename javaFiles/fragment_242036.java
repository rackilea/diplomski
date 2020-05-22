public abstract class Application {
    public Application newInstance() {
        try {
            return this.getClass().newInstance();//this creates an instance of the subclass 
        } catch( InstantiationException ie ){
            throw new RuntimeException( ie );
        } catch( IllegalAccessException iae ){
            throw new RuntimeException( iae );
        }
    }
    public String toString() {
        return "This is the class named: \""+ this.getClass().getSimpleName()+"\"";
    }
} 
// subclasses doesn't repeat the creation part
// they just have to override specific methods. 
class FirstClass extends Application {}
class SecondClass extends Application {}
class ThirdClass extends Application {}
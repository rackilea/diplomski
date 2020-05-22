public class YourWicketApp extends WebApplication{
    public static YourWicketApp get(){
        return (YourWicketApp) Application.get();
    }
    private ServiceA serviceA;
    // getter and setter for serviceA here
}
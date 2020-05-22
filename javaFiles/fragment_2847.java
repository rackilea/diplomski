public class CustomizedApplication extends Application {

@Override
public void onCreate() {
    // load secondary dex here
    Dexter.loadAllDexes(this);

    super.onCreate();

    //invoke method in secondary dex
    ClassInSecondaryDex.foo();
try{
    Class<?> clazz= Class.forName("your.package.ClassInSecondaryDex"); 
    clazz.getMethod("foo").invoke(clazz); 
}catch(Exception e)
{
e.printStackTrace();
}

}
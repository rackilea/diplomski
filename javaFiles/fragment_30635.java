@Lazy
@Repository
public class JustAClassThatPerhapsCompiles {

    private final String myProp; 
    private final Environment env;

    public JustAClassThatPerhapsCompiles(Environment env, 
                                         @Value("${app.my.prop}") String myProp) {
      this.env = env;
      this.myProp = myProp;
    }

    void justAFuncThatSomebodyWillTryToCompileMaybe(){
        env.getProperty("app.my.prop"); //env should no longer be null
        System.out.println(myProp); //myProp should no longer be null
    }
}
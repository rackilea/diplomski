//MainActivity is a consumer because it has requested nannyApplication using @Inject annotation
public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    NannyApplication nannyApplication /* You got the ApplicationContext */;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // AndroidInjection.inject(this); 
/* if Consumers want MainActivity instance then uncomment AndroidInjection.inject(this) line. Doing this makes MainActivity Consumer as well as Service component. Because it consumed nannyApplication but it has also provided (serviced) it's instance to the external world */
    }

    @Override
    protected void onStart() {
        super.onStart();
        //check nannyApplication
        Log.i("Cls-loader: ", nannyApplication.getClassLoader() + "");
    }
}
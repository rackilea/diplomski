public abstract class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      changeText(); // they dont have default implimentation in parent so it will be invoked from child class where these methods implimented
      changeText2();
   };


public abstract void changeText(); //there is no default implimentation

public abstract void changeText2();

}
public class Levels extends AppCompatActivity implements LevelOneResult.OnCompleteListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
    }

    public void onComplete(boolean enableOrNot ) {
        // after the action in LevelOne
        // the boolean trigger here..

        //here the boolean is true,which u set in levelOneJava
        if(enableOrNot){
            //then do your stuff here
        }
    }
}
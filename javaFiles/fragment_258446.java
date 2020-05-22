public class LevelOneResult extends AppCompatActivity {

    OnCompleteListener mListener;
    //create an listener
    public  interface OnCompleteListener {
         void onComplete(boolean enableOrNot);
    }
    //attach the listener in the activity
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.mListener = (OnCompleteListener)activity;
        }
        catch (final ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnCompleteListener");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one_result);


    }

    public void nextLevel(View view) {
        startActivity(new Intent(getApplicationContext(), Levels.class));
        // enable the button here

        here trigger the listener
        //true means enable
         mListener.onComplete(true);
    }
}
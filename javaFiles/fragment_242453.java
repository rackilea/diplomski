public class MainActivity extends AppCompatActivity {

    Button btnplus;
    RatingBar ratingbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     btnplus = (Button)findViewById(R.id.btnplus);
     ratingbar = (RatingBar)findViewById(R.id.ratingBar);
    }

    public void plusonclick()
    {
        if (ratingbar.getRating() == 1)
        {
            setContentView(R.layout.activity_plusrechnenlvl1);
        }
    }

}
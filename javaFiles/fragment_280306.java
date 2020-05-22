public class Breakfast extends AppCompatActivity implements View.OnClickListener {
    private int imageSelected;
    ImageView pancakes;
    ImageView frenchtoast;
    ImageView waffles;
    ImageView omelet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ... your code

        pancakes.setOnClickListener(this);
        frenchtoast.setOnClickListener(this);
        waffles.setOnClickListener(this);
        omelet.setOnClickListener(this);

        // ... more code
    }



    @Override
    public void onClick(View v) {
        imageSelected = v.getId();
    }

}
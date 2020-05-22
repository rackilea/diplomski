public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton imButton1 = (ImageButton) findViewById(R.id.imButton1);
        final ImageButton imButton2 = (ImageButton) findViewById(R.id.imButton2);
        final ImageButton imButton3 = (ImageButton) findViewById(R.id.imButton3);

        imButton1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) 
            {   
                imButton1.setBackgroundResource(R.drawable.icon1_selected);
                imButton2.setBackgroundResource(R.drawable.icon2_unselected);
                imButton3.setBackgroundResource(R.drawable.icon3_unselected);
            }
        });

        imButton2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) 
            {   
                imButton1.setBackgroundResource(R.drawable.icon1_unselected);
                imButton2.setBackgroundResource(R.drawable.icon2_selected);
                imButton3.setBackgroundResource(R.drawable.icon3_unselected);
            }
        });

        imButton3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) 
            {   
                imButton1.setBackgroundResource(R.drawable.icon1_unselected);
                imButton2.setBackgroundResource(R.drawable.icon2_unselected);
                imButton3.setBackgroundResource(R.drawable.icon3_selected);
            }
        });
    }
}
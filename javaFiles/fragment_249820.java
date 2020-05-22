public class MainActivity extends Activity implements OnClickListener{  
    ImageView img;
    LinearLayout LinearLayout1;
    LinearLayout.LayoutParams layoutParams; 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout1 = (LinearLayout) findViewById(R.id.ln1);
         layoutParams = new LinearLayout.LayoutParams(100, 100);
        for (int i = 0; i < 30; i++) {
            img = new ImageView(getApplicationContext());
            img.setId(i);
            img.setTag(i);           
            layoutParams.setMargins(10, 10, 10, 10);
            img.setLayoutParams(layoutParams);          
            img.setBackgroundColor(Color.RED);
            img.setPadding(10, 10, 10, 10);
            img.setOnClickListener(this);

            LinearLayout1.addView(img);            
        }
    }


    @Override
    public void onClick(View v) {
        ImageView b = (ImageView)v;     
        b.setBackgroundColor(Color.BLUE);
        b.setImageLevel(Integer.valueOf(String.valueOf(b.getTag())));
    }

}
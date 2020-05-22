public class MainActivity extends AppCompatActivity {

    private int clicked = 0;

    private ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.imageButton2); 
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn.setColorFilter(Color.argb(150, 255, 255, 255));//sets a tint

                // PART YOU ARE INTERESTED IN
                clicked++;
                Intent intent = new Intent(MainActivity.this, Someclass.class);
            }
        });
    }
}
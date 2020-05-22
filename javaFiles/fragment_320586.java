public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = (TextView)findViewById(R.id.a);
        b = (TextView)findViewById(R.id.b);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.a:
                Intent sub1 = new Intent(this, SubCategory.class);
                sub1.putExtra("BUTTON_CLICKED", "A");
                this.startActivity(sub1);
                break;
            case R.id.b:
                Intent sub2 = new Intent(this, SubCategory.class);
                sub2.putExtra("BUTTON_CLICKED", "B");
                this.startActivity(sub2);
                break;
        }
    }
}
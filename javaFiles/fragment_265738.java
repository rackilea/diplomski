public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    CheckBox cb1, cb2, cb3, cb4;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 =  findViewById(R.id.persona);
        cb2 = findViewById(R.id.car);
        cb3 = findViewById(R.id.calle);
        cb4 = findViewById(R.id.music);
        img = findViewById(R.id.imagen);

        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        int pattern = (cb1.isChecked() ? 0b0001 : 0)
                | (cb2.isChecked() ? 0b0010 : 0)
                | (cb3.isChecked() ? 0b0100 : 0)
                | (cb4.isChecked() ? 0b1000 : 0);
        switch (pattern) {
            // No selection
            case 0b0000:
                img.setImageResource(R.drawable.def);
                break;
            //Person
            case 0b0001:
                img.setImageResource(R.drawable.wick);
                break;
            //Car
            case 0b0010:
                img.setImageResource(R.drawable.car);
                break;
        }
    }
}
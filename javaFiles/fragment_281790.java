public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private TextView textView;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview1);

        CheckBox checkBox1 = findViewById(R.id.checkbox1);
        CheckBox checkBox2 = findViewById(R.id.checkbox2);
        CheckBox checkBox3 = findViewById(R.id.checkbox3);

        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked) {
            switch (buttonView.getId()) {
                case R.id.checkbox1:
                    list.add("Free");
                    break;
                case R.id.checkbox2:
                    list.add("Download");
                    break;
                case R.id.checkbox3:
                    list.add("Buy");
            }
        } else {
            switch (buttonView.getId()) {
                case R.id.checkbox1:
                    list.remove("Free");
                    break;
                case R.id.checkbox2:
                    list.remove("Download");
                    break;
                case R.id.checkbox3:
                    list.remove("Buy");
            }
        }

        textView.setText(TextUtils.join("-", list));
    }
}
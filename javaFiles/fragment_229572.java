public class MyActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private int counter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        // ........

        CheckBox checkBox1 = findViewById (R.id.checkbox1);
        CheckBox checkBox2 = findViewById (R.id.checkbox2);
        CheckBox checkBox3 = findViewById (R.id.checkbox3);

        checkBox1.setOnCheckedChangeListener (this);
        checkBox2.setOnCheckedChangeListener (this);
        checkBox3.setOnCheckedChangeListener (this);
    }

    @Override
    public void onCheckedChanged (CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            counter ++;
        } else {
            counter --;
        }
    }
}
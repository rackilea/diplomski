public class ButtonActivity extends AppCompatActivity {

    Button btnInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        btnInterface = findViewById(R.id.button_activity__btn__button_interface);
        setUpButtonInterface();
    }

    private void setUpButtonInterface() {
        btnInterface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do whatever you want to do when button is clicked!
            }
        });
    }
}
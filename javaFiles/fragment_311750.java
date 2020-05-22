public class ButtonActivity extends AppCompatActivity {

    Button btnInterface;
    ListenerButton listenerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        listenerButton = new ButtonListener();
        btnInterface = findViewById(R.id.button_activity__btn__button_interface);
        setUpButtonInterface();
    }

    private void setUpButtonInterface() {
        btnInterface.setOnClickListener(listenerButton);
    }
}
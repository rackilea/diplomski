public class MainActivity extends Activity {
    TextView terminal;
    Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        terminal = (TextView) findViewById(R.id.outputTerminal);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
    }

    // Defines the buttons behavior when clicked.
    public void buttonClicked(View v) {
        switch (v.getId()) {
        case R.id.button1:

            terminal.append("Button1 clicked...\n");
            break;

        case R.id.button2:

            terminal.append("Button2 clicked...\n");
            break;

        case R.id.button3:

            terminal.append("Button3 clicked...\n");
            break;

        case R.id.button4:

            terminal.append("Button4 clicked...\n");
            break;
        }
    }
}
public class MainActivity extends Activity {
    public LinearLayout mainWindow;
    public TextView mainText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainWindow = new LinearLayout(this);
        mainText = new TextView(this);

        mainWindow.addView(mainText);

        setContentView(mainWindow);
    }

}
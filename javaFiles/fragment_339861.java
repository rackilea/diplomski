public class MyActivity extends AppCompatActivity implements OnClickListener {

    private Button btnDark;
    private Button btnLight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);            
        // Set the theme
        // If there is nothing set, the light theme will be used by default
        setTheme(MyAppPreferences.getThemeId(this, R.style.Light));
        setContentView(R.layout.myLayout);

        btnDark = (Button) this.findViewById(R.id.viewbtnDark);
        btnDark.setOnClickListener(this);

        btnLight = (Button) this.findViewById(R.id.viewbtnLight);
        btnLight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // 1. Set the theme preference
        // 2. Recreate the activity to "apply" the theme
        if (v.equals(btnDark)) {
            MyAppPreferences.setThemeId(this, R.style.Dark);
            this.recreate();
        } else if (v.equals(btnLight)) {
            MyAppPreferences.setThemeId(this, R.style.Light);
            this.recreate();
        }
    }

}
SharedPreferences sharedpreferences;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login);
    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
}
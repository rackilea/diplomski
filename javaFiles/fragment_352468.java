@Override
protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home_screen);

    changeTheme();
}

private void changeTheme() 
{
    SharedPreferences settings = getSharedPreferences(Settings, 0);
    View currentView = (View) findViewById(R.id.activity_home_screen);

    if (settings.getBoolean("Blue", true)) 
    {
        currentView.setBackgroundColor(getResources().getColor(R.color.blue));
    } 
    else if (settings.getBoolean("Red", false)) 
    {
        currentView.setBackgroundColor(getResources().getColor(R.color.red));
    }
}
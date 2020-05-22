public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    /*check if username has been stored*/

    // if stored info exists, log the user in with login details and display main layout
        if(doesPersistExist(storedEmailName, PREFS_SESSION)){
            // auto login user
           // Once logged in, display tabbed layouts
                Intent i = new Intent(getApplicationContext(), MainTabbedActivity.class);
                startActivity(i);

        }

    // else, username has not been stored, prompt login
        else{
                setContentView(R.layout.login);
            }

}
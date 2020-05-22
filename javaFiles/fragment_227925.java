@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.content_main);
    addListenerOnButton();
}

public void addListenerOnButton() {

    final Context context = this;

    button = (Button) findViewById(R.id.main_text_view);  //<-- This tries to find a button in this activity (using the activity's layout file that was used in the call to setContentView() in onCreate().  However, the id you specify doesn't exist in your layout file.  This should either not compile or return null.

//This is fine.
    button.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {

            Intent intent = new Intent(context, main.class);  //<--"main.class" doesn't match either of the activity names declared in your manifest.  It should match one of the names declared in the <name> tag of one of your <activity> tags.
            startActivity(intent);

        }

    });

}
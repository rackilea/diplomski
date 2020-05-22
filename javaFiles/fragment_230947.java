protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button = findViewById(R.id.your_button);
        //This will give NullPointerException as you're trying to find
        //button before activity gets any layout to work with
        setContentView(R.layout.activity_main);
}
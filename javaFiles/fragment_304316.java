private static final String NAME = "my_pref";
        private static final String ACTION_BAR_TITLE = "action_bar_title";
        private SharedPreferences sharedPreferences;
        private SharedPreferences.Editor editor;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);


          }
...
buttonSet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                String title = editTextHouse.getText().toString();
                getSupportActionBar().setTitle(title);
                editor = sharedPreferences.edit();
                editor.putString(ACTION_BAR_TITLE, title);
                editor.apply();
                }
            });

...
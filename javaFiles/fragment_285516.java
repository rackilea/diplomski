public class MovieDetails extends AppCompatActivity {
    private static final String SHARED_PF_NAME = "favoriteMovies";
    private Movie movie; // I'm guessing the class name is Movie
    private CheckBox checkBox;
    private SharedPreferences sharedPreferences;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_details);
        getSupportActionBar().setTitle("Movie Details");

        movie = getIntent().getParcelableExtra(
            MainActivity.MOVIE_IN_CURRENT_CLICKED_POSITION);
        final String key = Integer.toString(movie.getMovieId());

        // all the other stuff...

        sharedPreferences = getSharedPreferences(SHARED_PF_NAME, Context.MODE_PRIVATE);
        checkBox = findViewById(R.id.checkbox_button);
        checkBox.setChecked(sharedPreferences.getBoolean(key, false));
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    sharedPreferences.edit().putBoolean(key, true).apply();
                    Toast.makeText(getApplicationContext(), "checked",
                            Toast.LENGTH_LONG).show();
                } else {
                    sharedPreferences.edit().remove(key).apply();
                    Toast.makeText(getApplicationContext(), "not checked",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
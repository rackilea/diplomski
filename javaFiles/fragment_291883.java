@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_random_race);

    TextView name = (TextView)findViewById(R.id.raceName);
    Intent secondIntent = getIntent();
    Race message = (Race)secondIntent.getSerializableExtra("RACE");

    ImageView image = (ImageView) findViewById(R.id.raceImage);
    image.setImageResource(getResources().getIdentifier(message.getImageName(),
                                                        "drawable",
                                                        getPackageName()));

    name.setText(message.getName());
}
String rootActivity;
    int songsID;
    TextView title;
    TextView text;
    TextView author;
    Song displayedSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_view);

        title = findViewById(R.id.title_song_tv);
        text = findViewById(R.id.tv_scrolling_song_text);
        author = findViewById(R.id.author_song_tv);
        songsID = getIntent().getExtras().getInt("EXTRA_SONG_ID");
        rootActivity = getIntent().getExtras().getString("EXTRA_ROOT_ACTIVITY");

        for(Song song : Generator.getSongs()){
            if(song.getId() == songsID){
                author.setText(song.getAuthor());
                title.setText(song.getTittle());
                text.setText(song.getText());
                displayedSong = song;
            }
        }
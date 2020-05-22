ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        list = findViewById(R.id.song_item_list_view);

        SongItemArrayAdapter adapter = new SongItemArrayAdapter(this, Generator.getSampleSongs());
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Song item = (Song) list.getItemAtPosition(position);
                Intent intent = new Intent(BrowserActivity.this, SongViewActivity.class);
                intent.putExtra("EXTRA_SONG_ID", item.getId());
                intent.putExtra("EXTRA_ROOT_ACTIVITY", SongViewActivity.Roots.browserActivity.toString());
                startActivity(intent);
            }
        });
    }
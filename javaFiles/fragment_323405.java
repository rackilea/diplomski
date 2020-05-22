public class MainActivity extends AppCompatActivity {

    ListView lv;
    MediaPlayer mp;
    ArrayList<Memes> item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        mp = new MediaPlayer();

        item = new ArrayList<>();

        item.add(new Memes("Gemidão", R.raw.gemidaoremix));
        item.add(new Memes("Nunca nem vi", R.raw.nuncanemvi));


        ArrayAdapter<Memes> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, item);
        lv.setAdapter(adapter);

        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, item));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                playSong(position);

            }
        });
    }

    public void playSong(int songIndex) {
        mp.reset();
        mp = MediaPlayer.create(this, item.get(songIndex).getResId());
        mp.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.release();
    }


}
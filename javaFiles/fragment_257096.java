Full code:
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.foood);

    ImageButton btnbreakfast = (ImageButton) findViewById(R.id.breakfast);

    btnbreakfast.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View V) {
            MediaPlayer audio = MediaPlayer.create(Food.this, R.raw.vada);
            audio.start();
    audio.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    nextScreen();
                }
            });
        }
    });
}

public void nextScreen() {
    Intent intent = new Intent(Food.this, breakfast.class);
    startActivity(intent);
}
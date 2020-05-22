public class MainActivity extends AppCompatActivity {
    private int [] imagens = {R.drawable.tabeladia2, R.drawable.tabeladia3,
            R.drawable.tabeladia4, R.drawable.tabeladia5};

    private Button proxima;
    private ImageView img;
    private Integer currentImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        proxima = findViewById(R.id.proximaId);

        img = findViewById(R.id.imageView);

        proxima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentImg != null && currentImg < 3) {
                    currentImg++;
                } else {
                    currentImg = 0;
                }
                img.setImageResource(imagens[currentImg]);
            }
        });
    }
}
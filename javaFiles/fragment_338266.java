public class MainActivity extends AppCompatActivity {
            private int [] imagens = {R.drawable.tabeladia2, R.drawable.tabeladia3,
                    R.drawable.tabeladia4, R.drawable.tabeladia5};

            private Button proxima;
            private ImageView img;
            private Integer currentImg;

            private int[] intArray = new int[4];

            @Override
            protected void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                proxima = findViewById(R.id.proximaId);

                img = findViewById(R.id.imageView);

                proxima.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (currentImg != null) {
                            if (currentImg < 3) {
                                currentImg++;
                                if(currentImg == 1){
                                  intArray[1] = 2;
                                }else if(currentImg == 2){
                                  intArray[2] = 4;
                                }else if(currentImg == 3){
                                  intArray[3] = 8;}
                                img.setImageResource(imagens[currentImg]);
                            }else{
                                //handle last image reached condition
                                Toast.makeText(MainActivity.this, "Last image reached", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            currentImg = 0;
                            intArray[0] = 1;
                            img.setImageResource(imagens[currentImg]);
                        }
                    }
                });
            }
        }
public class SegundaTela extends AppCompatActivity {
    private Integer[] imagens = new Integer[]{R.drawable.tabeladia2, R.drawable.tabeladia3, R.drawable.tabeladia4, R.drawable.tabeladia5};
    private RadioGroup radioGroup;
    private RadioButton sim;
    private RadioButton nao;
    private Button proxima;
    private ImageView img;
    private Integer i;
    private int soma = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        img = findViewById(R.id.imageView);
        proxima = findViewById(R.id.proximaId);
        radioGroup = findViewById(R.id.RadioGroupId);
        sim = findViewById(R.id.simId);
        nao = findViewById(R.id.naoId);


        proxima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!sim.isChecked() && !nao.isChecked()) {
                    Toast.makeText(SegundaTela.this, "Select an option", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (i != null) {
                    if (i < 5) {
                        switch (i) {
                            case 0:

                                if (sim.isChecked()) {
                                    img.setImageResource(imagens[i]);
                                    //dados[j] = 2;
                                    soma = soma + 2;

                                } else if (nao.isChecked()) {
                                    img.setImageResource(imagens[i]);
                                    //dados[j] = 0;
                                    soma = soma + 0;
                                }
                                break;
                            case 1:

                                if (sim.isChecked()) {
                                    img.setImageResource(imagens[i]);
                                    //dados[j] = 4;
                                    soma = soma + 4;

                                } else if (nao.isChecked()) {
                                    img.setImageResource(imagens[i]);
                                    //dados[j] = 0;
                                    soma = soma + 0;
                                }
                                break;
                            case 2:

                                if (sim.isChecked()) {
                                    img.setImageResource(imagens[i]);
                                    //dados[j] = 8;
                                    soma = soma + 8;

                                } else if (nao.isChecked()) {
                                    img.setImageResource(imagens[i]);
                                    //dados[j] = 0;
                                    soma = soma + 0;
                                }
                                break;
                            case 3:

                                if (sim.isChecked()) {
                                    img.setImageResource(imagens[i]);
                                    //dados[j] = 16;
                                    soma = soma + 16;

                                } else if (nao.isChecked()) {
                                    img.setImageResource(imagens[i]);
                                    //dados[j] = 0;
                                    soma = soma + 0;
                                }
                                break;
                            case 4:
                                /*if (sim.isChecked()) {
                                    //dados[j] = 16;
                                    soma = soma + 32;

                                } else if (nao.isChecked()) {
                                    //dados[j] = 0;
                                    soma = soma + 0;
                                }*/
                                Intent i = new Intent(SegundaTela.this, MainActivity.class);
                                i.putExtra("soma", soma);
                                startActivity(i);
                                break;
                        }
                        ++i;
                        Toast.makeText(SegundaTela.this, "soma: " + soma, Toast.LENGTH_SHORT).show();
                        radioGroup.clearCheck();

                    } /*else {
                        //soma = dados[0] + dados[1] + dados[2] + dados[3] + inicio;
                        Intent i = new Intent(SegundaTela.this, MainActivity.class);
                        i.putExtra("soma", soma);
                        startActivity(i);
                    }*/
                }else {
                    if (sim.isChecked()) {
                        //inicio = 1;
                        soma = soma + 1;
                    } else if (nao.isChecked()) {
                        //inicio = 0;
                        soma = soma + 0;
                    }
                    i = 0;
                    radioGroup.clearCheck();
                }
            }


        });

    }
}
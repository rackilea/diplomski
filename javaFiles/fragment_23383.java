public class MainActivity extends AppCompatActivity implements View.OnClickListener { //!!!

    private Banco banco;

    private Giocatore giocatore1;
    private Giocatore giocatore2;
    private Giocatore giocatoreAttuale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        giocatore1 = new GiocatoreUmano();
        giocatore2 = new GiocatoreUmano();

        banco = new Banco(giocatore1,giocatore2);
        giocatoreAttuale=giocatore1;
        DaiCarteAiGiocatori();
        DaiCarteAlPlayerOne();
    }

    private void DaiCarteAlPlayerOne(){

        Button primaCarta = new Button(this);  //BUTTON OF THE CARD
        primaCarta.setOnClickListener(MainActivity.this); //!!!
    primaCarta.setText(giocatore1.getCartaByIndex(0).getSeme().toString()+":"+giocatore1.getCartaByIndex(0).getValore());

        ConstraintLayout layout = findViewById(R.id.baseLayout);
        layout.addView(primaCarta);

          Animation animation = AnimationUtils.loadAnimation(this, R.anim.move_cards); // THE ANIMATION
          primaCarta.startAnimation(animation);



    }

    //!!!
    @Override
        public void onClick(View v) {
     banco.giocaCarte(giocatore1,giocatore1.getCartaByIndex(0));
                Log.i("CARTA","Carta Premuta");
        }

    private void DaiCarteAiGiocatori(){
        banco.pescaCarte();
    }
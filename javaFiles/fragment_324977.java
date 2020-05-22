public class TelaCadastroRestaurante extends Activity {

   private Button proximoButton;
   private EditText nomeRestauranteEditText, emailRestauranteEditText, telefoneRestauranteEditText;

   private String nomeRestauranteValores, emailRestauranteValores;
   private int telefoneRestauranteValores;

   private String voceTemCerteza = "Você tem certeza que deseja cadastrar o restaurante ";

   private final Restaurante rest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_tela_cadastro_restaurante);
     incializarComponentes();
     acaoBotoes();
        }

    public void incializarComponentes() {
     nomeRestauranteEditText = (EditText)                   findViewById(R.id.editTextNomeRestauranteTelaCadastroRestaurante);
     emailRestauranteEditText = (EditText) findViewById(R.id.editTextEmailRestauranteTelaCadastroRestaurante);
      telefoneRestauranteEditText = (EditText) findViewById(R.id.editTextTelefoneRestauranteTelaCadastroRestaurante);
      proximoButton = (Button) findViewById(R.id.buttonProximoTelaCadastroRestaurante);
   }

  public void acaoBotoes() {
   proximoButton.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        pegarValores();
        callMandarNuvem();
    }
});
}

  public void pegarValores(){
     rest = new Restaurante();

   nomeRestauranteValores =       nomeRestauranteEditText.getText().toString();
   emailRestauranteValores = emailRestauranteEditText.getText().toString();
   telefoneRestauranteValores = Integer.parseInt(telefoneRestauranteEditText.getText().toString());

   rest.setNomeRest(nomeRestauranteValores);
   rest.setEmailRest(emailRestauranteValores);
   rest.setTelefoneRest(telefoneRestauranteValores);

  }

  public void callMandarNuvem(){
     Runnable r = new Runnable() {
    public void run() {
        Metodos.mandarNuvem(TelaCadastroRestaurante.this);
    }
};

   Metodos.caixaCerteza(TelaCadastroRestaurante.this, voceTemCerteza + rest.getNomeRest() + "?",r);
public class DialogFormReg extends Dialog {
private DBHelper DB1;//try public too
private Context ctx;
public DialogFormReg(Context context) {//, boolean cancelable, OnCancelListener cancelListener
    super(context);//, cancelable, cancelListener
    ctx = context; //try it, don't work
}

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.registrazione_layout);
    DB1 = new DBHelper(ctx); 
    String[] datiut= DB1.RecuperaDatiUtente();
}
    btConfRegistra.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

            cel1 = edtCell1.getText().toString();
            mail = edtMail.getText().toString();
            indi = edtIndirizzo.getText().toString();
            nome = edtNome.getText().toString();
            cog = edtCognome.getText().toString();
            naz = edtNazione.getText().toString();
            loc = edtLocalita.getText().toString();
            telefono = edtTelefono.getText().toString();

            String[] datiu= DB1.RecuperaDatiUtente();
            boolean reg = false;    

            Log.e("size",""+datiu.length);

            if (!datiu[0].equalsIgnoreCase("default-209288")) {     
                //This only works if the instance is created in the DBHelper Activity
                reg = DB1.RegistraDatiUtente(datiu[0], datiu[1], datiu[2], datiu[3], datiu[4], datiu[5], datiu[6], datiu[7]);
                if (reg) {
                    Toast.makeText(getContext(), "Dati Aggiornati", Toast.LENGTH_LONG).show();
                    dismiss();
                } else {
                    Toast.makeText(getContext(), "Errore in aggiornamento dati, ripetere", Toast.LENGTH_LONG).show();
                }
            } else {
                //This always works well
                reg= DB1.RegistraDatiUtente(nome, cog, indi, mail, cel1, telefono, naz, loc);
                if (reg) {
                    Toast.makeText(getContext(), "Dati Registrati", Toast.LENGTH_LONG).show();
                    dismiss();
                }else {
                    Toast.makeText(getContext(), "Errore in registrazione dati, ripetere", Toast.LENGTH_LONG).show();
                }                   
            }
        }
    });

}